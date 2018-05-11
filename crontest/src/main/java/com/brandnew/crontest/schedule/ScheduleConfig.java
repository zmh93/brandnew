package com.brandnew.crontest.schedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.Date;

//自带的定时任务功能，相当于一个轻量级的Quartz
@Configuration
@EnableScheduling
@Slf4j
public class ScheduleConfig {

    //cron表达式 在线生成：http://cron.qqe2.com/
    @Scheduled(cron = "0/10 * * * * ?")
    public void logWritten() {
        log.warn("定时任务执行了,time:{}",new Date());
    }
}
