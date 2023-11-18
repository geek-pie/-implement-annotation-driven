package com.bscoder.annotation.aop.c02;


import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Proxy;

public class ConsumerAgentDemo {

    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ConsumerAgent());
        pf.setTarget(new Consumer());
        Consumer proxy = (Consumer) pf.getProxy();

        System.out.println("Consumer 是否是JDK动态代理:" + Proxy.isProxyClass(proxy.getClass()));

        proxy.doSomething();
    }
}
