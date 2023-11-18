package com.bscoder.annotation.chapter3;

import java.lang.annotation.*;
import java.lang.reflect.Method;


public class GetInherited {
    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface InheritedAnnotation {
        String name() default "";
    }


    @InheritedAnnotation(name = "parent")
    public class Parent {
        @InheritedAnnotation(name = "parent.sayHello")
        public void sayHello(String name) {
            System.out.println("hello," + name);
        }
    }

    public class Child extends Parent {

        @Override
        public void sayHello(String name) {
            super.sayHello(name);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Child> child = Child.class;

        //获取获取当前element存在的直接注解、关联注解
        InheritedAnnotation myAnnotation = child.getAnnotation(InheritedAnnotation.class);

        if (myAnnotation != null) {
            System.out.println("getAnnotation可以获取到关联注解！");

        }
        myAnnotation = child.getDeclaredAnnotation(InheritedAnnotation.class);
        if (myAnnotation == null) {
            System.out.println("getDeclaredAnnotation无法获取关联注解！");
        }

        //测试注解到方法上是否有效
        Method method = Child.class.getMethod("sayHello", String.class);
        System.out.println("是否能获取注解到子类上方法上的注解：" + method.getAnnotation(InheritedAnnotation.class) == null);
        System.out.println("是否能获取注解到子类上方法上的注解：" + method.getDeclaredAnnotation(InheritedAnnotation.class) == null);
    }
}
