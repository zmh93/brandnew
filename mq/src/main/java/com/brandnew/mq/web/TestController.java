package com.brandnew.mq.web;

import com.brandnew.mq.mq.MqConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private  RabbitTemplate rabbitTemplate;

    @GetMapping("/")
    public Object index() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("test", "object");
        rabbitTemplate.convertAndSend(MqConfig.topicExchangeName, "foo.bar.baz", map);
        return "send message success";
    }
}
