package com.bscoder.annotation.chapteraop01;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年05月05日 16:02
 */
public class ConsumerAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("准备执行");
        Object result = invocation.proceed();
        System.out.println("执行完毕");
        return result;
    }


    public static void main(String[] args) {


    }
}
