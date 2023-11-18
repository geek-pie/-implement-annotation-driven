package com.bscoder.annotation.chapteraop01;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年05月05日 16:09
 */
public class ConsumerAgentDemo {

    public static void main(String[] args) {
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ConsumerAdvice());
        pf.setTarget(new Consumer());
        Consumer proxy = (Consumer) pf.getProxy();
        proxy.consume();
    }
}
