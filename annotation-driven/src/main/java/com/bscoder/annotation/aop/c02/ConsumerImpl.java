package com.bscoder.annotation.aop.c02;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ConsumerImpl implements IConsumer {

    @Override
    @Async
    public void doSomething() {
        System.out.println("客户自己做事");
    }
}
