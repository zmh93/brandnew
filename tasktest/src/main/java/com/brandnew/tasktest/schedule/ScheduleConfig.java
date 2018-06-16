package com.brandnew.tasktest.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

//自带的定时任务功能，相当于一个轻量级的Quartz
//cron表达式 在线生成：http://cron.qqe2.com/
//@Configuration
@EnableScheduling
@Slf4j
public class ScheduleConfig {

    @Scheduled(cron = "0/10 * * * * ?")
    public void logWritten() {
        log.warn("定时任务执行了,time:{}",new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

}
