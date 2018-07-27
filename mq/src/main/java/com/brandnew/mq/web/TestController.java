package com.brandnew.mq.web;

import com.brandnew.mq.mq.MqConfig;
import com.brandnew.mq.service.IUserService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class TestController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private IUserService receiver;

    @GetMapping("/")
    public Object index() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("sign", "commit");
        rabbitTemplate.convertAndSend(MqConfig.topicExchangeName, "foo.bar.baz", map);
        return "send message success";
    }

}
