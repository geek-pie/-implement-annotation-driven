package com.bscoder.annotation.chapter6;

import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@MergedAnnotationsTest.MyAnnotation(id = "MergedAnnotationsTest")
public class MergedAnnotationsTest {

    @Target({ElementType.METHOD, ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String id();
    }

    @MyAnnotation(id = "parsent")
    class Parent {


    }

    class Child extends Parent {

    }

    public static void main(String[] args) {
        MergedAnnotation<MyAnnotation> annotation =
                MergedAnnotations.from(MergedAnnotationsTest.class, MergedAnnotations.SearchStrategy.DIRECT).get(MyAnnotation.class);
        System.out.println(annotation.isPresent() + "-" + annotation.getString("id"));
        annotation =
                MergedAnnotations.from(Child.class, MergedAnnotations.SearchStrategy.SUPERCLASS).get(MyAnnotation.class);
        System.out.println(annotation.isPresent() + "-" + annotation.getString("id"));
    }
}
