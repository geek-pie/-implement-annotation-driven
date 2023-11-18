package com.bscoder.annotation.chapter2;


import java.lang.annotation.*;


public class InheritedAnnotationTest {
    @Target({ElementType.TYPE})
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface InheritedAnnotation {
        String name() default "";

    }

    @InheritedAnnotation(name = "parent")
    public class Parent {
    }

    @InheritedAnnotation(name = "parent")
    public interface IParent {
    }


    public class ChildImpl implements IParent {
    }

    public class Child extends Parent {
    }

    public static void main(String[] args) {
        InheritedAnnotation annotation = Child.class.getAnnotation(InheritedAnnotation.class);
        System.out.println(annotation.name());
        System.out.println(ChildImpl.class.getAnnotation(InheritedAnnotation.class));
    }
}