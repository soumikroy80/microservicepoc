package com.spring.redis.core;

import java.util.concurrent.CountDownLatch;

import org.springframework.beans.factory.annotation.Autowired;

public class Receiver {

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }
}