package com.bscoder.annotation.chapter2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;


public class DocumentedTest {

    @Documented
    @Target({ElementType.METHOD})
    public @interface DocAnnotation {
        String value() ;

    }

    @DocAnnotation(value = "DocumentedTest.say")
    public void say(String name) {
        System.out.println(name);
    }

}

