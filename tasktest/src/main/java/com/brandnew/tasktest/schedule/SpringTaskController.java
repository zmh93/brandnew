package com.brandnew.tasktest.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledFuture;

/**
 * spring task test
 * 通过Task任务调度器实现任务的调度和删除
 *
 * @author zmh email: zmhzhaomenghui@gmail.com
 * @createDate 2018/6/16
 */
@RestController
@EnableScheduling
@Slf4j
public class SpringTaskController {

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
    @Autowired
    private AsyncTaskController     asyncTaskController;

    private ScheduledFuture<?> future;

    @GetMapping("newTask")
    public String newTask(String taskName) {
        //cron表达式 在线生成：http://cron.qqe2.com/
        String         cronStr = "0/5 * * * * ? ";
        resetTask(taskName.equals("task2") ? task2() : task1(), cronStr);
        return "new task settled:" + taskName;
    }

    private void resetTask(Runnable task, String cronStr) {
        if (future != null) {
            future.cancel(true);
        }
        future = threadPoolTaskScheduler.schedule(task, new CronTrigger(cronStr));
    }

    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Bean
    private Task1 task1() {
        return new Task1();
    }

    @Bean
    private Task2 task2() {
        return new Task2();
    }
}

class Task1 implements Runnable {

    @Override
    public void run() {
        System.out.println("\n>>>task1 执行了,执行时间:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}

class Task2 implements Runnable {

    @Override
    public void run() {
        System.out.println("\n>>>task2 执行了,执行时间:" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }
}


