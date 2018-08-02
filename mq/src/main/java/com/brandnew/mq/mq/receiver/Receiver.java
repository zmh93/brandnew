package com.brandnew.mq.mq.receiver;

import com.brandnew.mq.mq.entity.Message1;
import com.brandnew.mq.mq.mapper.MessageMapper;
import com.brandnew.mq.mq.sender.MqConstant;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Receiver {

//    private CountDownLatch latch = new CountDownLatch(5);

    @Autowired
    private MessageMapper messageMapper;

    @RabbitListener(queues = MqConstant.queueName1)
    public void receiveMessage1(Message1 message) {
        System.out.println("Received message:" + message.toString());
        messageMapper.insert(message);
    }


    @RabbitListener(queues = MqConstant.queueName2)
    public void receiveMessage2(Message1 message) {
        System.out.println("Received message:" + message.toString());
        messageMapper.insert(message);
    }


}
