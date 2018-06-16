package com.brandnew.tasktest.schedule;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: AsyncTaskController
 * Description: 使用线程池多线程执行任务
 *
 * @author zhaomenghui93@163.com
 * @createDate 2018/6/16
 */
@RestController
@EnableAsync
@Data
public class AsyncTaskController implements Runnable {

    private int                    executeFlag = 0;
    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @GetMapping("bundleTask")
    public String beginBundleTask() {
        for (int i = 0; i < 30; i++) {
            threadPoolTaskExecutor.execute(this);
            threadPoolTaskExecutor.execute(this);
        }
        return "bundle task begin!";
    }

    @Override
    public void run() {
        System.out.println("线程" + Thread.currentThread().getName() + "执行第" + ++executeFlag + "次");
    }

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(10);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.initialize();
        return taskExecutor;
    }
}
