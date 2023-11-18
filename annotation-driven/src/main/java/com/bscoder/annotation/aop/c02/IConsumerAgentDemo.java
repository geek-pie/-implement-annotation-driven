package com.bscoder.annotation.aop.c02;


import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

public class IConsumerAgentDemo {

    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ConsumerAgent());

        IConsumer consumer = new ConsumerImpl();
        pf.setTarget(consumer);
        System.out.println(consumer.getClass().isInterface());
        ConsumerImpl proxy = (ConsumerImpl) pf.getProxy();
        System.out.println("IConsumer 是否是JDK动态代理:" + Proxy.isProxyClass(proxy.getClass()));
        proxy.doSomething();
    }
}
