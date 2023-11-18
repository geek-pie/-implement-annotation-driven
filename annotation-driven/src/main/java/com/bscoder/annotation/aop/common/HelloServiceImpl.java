package com.bscoder.annotation.aop.common;

import org.springframework.stereotype.Component;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年07月18日 15:23
 */

@Component
public class HelloServiceImpl implements HelloService {


    @Override
    public String hello(String name) {
        System.out.println("Hello," + name + "！");
        return name;
    }
}
