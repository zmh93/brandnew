package com.brandnew.mq.mq;

import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(Object message) {
        System.out.println("Received <" + message.toString() + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
