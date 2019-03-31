package com.brandnew.mq.mq.sender;

import com.brandnew.mq.mq.entity.Message1;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MqSenderUtil {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void broadcast(String routingKey, Message1 message1) {
        rabbitTemplate.convertAndSend(MqConstant.fanoutExchangeName, routingKey, message1);
    }

    public void sendTopicMsg(String routingKey, Message1 message1) {
        rabbitTemplate.convertAndSend(MqConstant.topicExchangeName, routingKey, message1);
    }

    public void sendDirectMsg(String routingKey, Message1 message1) {
        rabbitTemplate.convertAndSend(MqConstant.directExchangeName,routingKey,message1);
    }
}
