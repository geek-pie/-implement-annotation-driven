package com.bscoder.annotation.aop.c02;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



public class ConsumerAgent implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("执行前的处理");
        Object result = invocation.proceed();
        System.out.println("执行前后的处理");
        return result;
    }
}