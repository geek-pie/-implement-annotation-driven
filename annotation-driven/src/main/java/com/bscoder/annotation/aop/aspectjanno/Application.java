package com.bscoder.annotation.aop.aspectjanno;

import com.bscoder.annotation.aop.common.HelloServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@ComponentScan(basePackages = {"com.bscoder.annotation.aop.aspectjanno","com.bscoder.annotation.aop.common"})
@EnableAspectJAutoProxy
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        HelloServiceImpl helloServiceImpl = applicationContext.getBean(HelloServiceImpl.class);
        helloServiceImpl.hello("BaShuCoder");
    }
}
