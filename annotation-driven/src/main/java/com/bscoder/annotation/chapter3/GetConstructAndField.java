package com.bscoder.annotation.chapter3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


public class GetConstructAndField {

    @Target({ElementType.CONSTRUCTOR})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String name() default "";
    }

    public class Parent {
        public @MyAnnotation(name = "parent")
        Parent() {
        }
    }

    public class Child extends Parent {
        @MyAnnotation(name = "child")
        public Child() {
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        MyAnnotation childAnnotation = Child.class.getConstructors()[0].getAnnotation((MyAnnotation.class));
        if (childAnnotation != null) {
            System.out.println(childAnnotation.name());
        }
        MyAnnotation parentAnnotation = Parent.class.getConstructors()[0].getAnnotation((MyAnnotation.class));
        if (parentAnnotation != null) {
            System.out.println(parentAnnotation.name());
        }


        Method method = Child.class.getMethod("Child");
        System.out.println(method);
    }
}
