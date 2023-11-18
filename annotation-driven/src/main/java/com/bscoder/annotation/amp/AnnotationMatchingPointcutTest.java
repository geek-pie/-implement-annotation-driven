package com.bscoder.annotation.amp;

import com.bscoder.annotation.common.Logging;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.lang.Nullable;

import java.lang.annotation.Annotation;


/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月11日 15:41
 */
public class AnnotationMatchingPointcutTest {


    public static void main(String[] args) {



        Pointcut mpc =   new AnnotationMatchingPointcut(null, Logging.class, true) ;
        DefaultPointcutAdvisor defaultPointcutAdvisor = new DefaultPointcutAdvisor(mpc, new LoggingAdvice());
        ProxyFactory proxyFactory1 = new ProxyFactory(new MyServiceImpl());
        proxyFactory1.addAdvisor(defaultPointcutAdvisor);





//      System.out.println();  AnnotatedElementUtils.hasAnnotation(AbstractMyServiceImpl.class.getMethod("sayBye", String.class),Logging.class)));
//        MyService myService = (MyService) proxyFactory1.getProxy();
//        myService.sayHello("MyService，平凡的码农");


        ProxyFactory proxyFactory2 = new ProxyFactory(new AbstractMyServiceImpl());
        proxyFactory2.addAdvisor(defaultPointcutAdvisor);



        AbstractMyServiceImpl abstractMyService = (AbstractMyServiceImpl) proxyFactory2.getProxy();
        abstractMyService.sayBye("AbstractMyService，平凡的码农");
    }
}
