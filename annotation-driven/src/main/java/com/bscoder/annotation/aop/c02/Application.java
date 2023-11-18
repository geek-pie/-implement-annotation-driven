package com.bscoder.annotation.aop.c02;

import com.bscoder.annotation.aop.common.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;


@ComponentScan(basePackages = {"com.bscoder.annotation.aop.c02"})
@EnableAsync
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        IConsumer helloServiceImpl = applicationContext.getBean(IConsumer.class);
        helloServiceImpl.doSomething();
    }
}
