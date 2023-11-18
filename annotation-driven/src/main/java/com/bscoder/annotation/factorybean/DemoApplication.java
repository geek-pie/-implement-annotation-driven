package com.bscoder.annotation.factorybean;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws NoSuchAlgorithmException {
//        AnnotationConfigApplicationContext context = (AnnotationConfigApplicationContext) SpringApplication.run(DemoApplication.class, args);
//
//        Person person = context.getBean(Person.class, "person");
//        System.out.println(person.getCar());
//
//        MyBean car2 = context.getBean("BMW", MyBean.class);
//        System.out.println(car2 == person.getCar());
//
//        CarFactoryBean myCarFactoryBean = context.getBean("&BENZ", CarFactoryBean.class);
//        System.out.println(myCarFactoryBean.getObject());


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CarConfiguration.class);

        Person person = context.getBean(Person.class, "person");

        System.out.println(context.getBeanFactoryPostProcessors().size());

        for (BeanFactoryPostProcessor beanFactoryPostProcessor : context.getBeanFactoryPostProcessors()) {
            System.out.println("beanFactoryPostProcessor:" + beanFactoryPostProcessor);
        }

        System.out.println(person);


    }

}
