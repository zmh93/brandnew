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

    @GetMapping("/bc-all")
    public Object queue1() {
        Message1 message1 = new Message1();
        message1.setInfo("queue1`s one message");
        message1.setSendTime(new Date());
        mqSenderUtil.broadcast(MqConstant.routingKeyAll,message1);
        return "send message success";
    }

    @GetMapping("/f-r1")
    public Object r1() {
        Message1 message1 = new Message1();
        message1.setInfo("queue1`s one message");
        message1.setSendTime(new Date());
        mqSenderUtil.sendTopicMsg(MqConstant.routingKey1,message1);
        return "send message success";
    }

    @GetMapping("/f-r2")
    public Object r2() {
        Message1 message1 = new Message1();
        message1.setInfo("queue2`s one message");
        message1.setSendTime(new Date());
        mqSenderUtil.sendTopicMsg(MqConstant.routingKey2,message1);
        return "send message success";
    }

    @GetMapping("/f-r1-many")
    public Object r1Many() {
        Message1 message1 = new Message1();
        message1.setInfo("queue2`s one message");
        message1.setSendTime(new Date());
        for (int i = 0; i < 10; i++) {
            mqSenderUtil.sendTopicMsg(MqConstant.routingKey2,message1);
        }
        return "send message success";
    }

    @GetMapping("/d-r1-many")
    public Object dr1Many() {
        Message1 message1 = new Message1();
        message1.setInfo("queue1`s one message");
        message1.setSendTime(new Date());
        for (int i = 0; i < 10; i++) {
            mqSenderUtil.sendDirectMsg(MqConstant.routingKey1,message1);
        }
        return "send message success";
    }
}
