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

    @RabbitListener(queues = "com.zmh.queue1")
    public void recever1(Message1 message) {
        System.out.println("queue1:Received message:" + message.toString());
        messageMapper.insert(message);
    }


    @RabbitListener(queues = "com.zmh.queue2")
    public void recever2(Message1 message) {
        System.out.println("queue2: Received message:" + message.toString());
        messageMapper.insert(message);
    }


}
