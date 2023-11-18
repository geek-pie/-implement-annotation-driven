package com.bscoder.annotation.amp;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


/**
 * @author bscoder
 */
public class LoggingAdvice implements MethodInterceptor {


    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println(" before method execute：" + invocation.getMethod().getName());
        Object result = invocation.proceed();
        System.out.println(" after method execute：" + result);
        return result;
    }
}
