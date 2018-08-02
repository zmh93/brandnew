package com.brandnew.mq.web;

import com.brandnew.mq.mq.entity.Message1;
import com.brandnew.mq.mq.sender.MqConstant;
import com.brandnew.mq.mq.sender.MqSenderUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private MqSenderUtil mqSenderUtil;

    @GetMapping("/queue1")
    public Object queue1() {
        Message1 message1 = new Message1();
        message1.setInfo("queue1`s one message");
        message1.setSendTime(new Date());
        mqSenderUtil.sendMessage(MqConstant.queueName1,message1);
        return "send message success";
    }

    @GetMapping("/queue2")
    public Object queue2() {
        Message1 message1 = new Message1();
        message1.setInfo("queue2`s one message");
        message1.setSendTime(new Date());
        mqSenderUtil.sendMessage(MqConstant.queueName2,message1);
        return "send message success";
    }

}
