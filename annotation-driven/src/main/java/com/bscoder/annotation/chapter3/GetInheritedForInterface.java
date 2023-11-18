package com.bscoder.annotation.chapter3;

import java.lang.annotation.*;
import java.lang.reflect.Method;


public class GetInheritedForInterface {
    @Inherited
    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation {
        String name() default "";
    }


    @MyAnnotation(name = "parent")
    public interface Parent {

        @MyAnnotation(name = "parent.sayHello")
        void sayHello(String name);
    }

    public class Child implements Parent {

        @Override
        public void sayHello(String name) {

        }
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<Child> child = Child.class;

        //获取获取当前element存在的直接注解、关联注解
        MyAnnotation myAnnotation = child.getAnnotation(MyAnnotation.class);

        if (myAnnotation == null) {
            System.out.println("getAnnotation无法获取到注解到父类接口的@Inherited注解！");

        }
        myAnnotation = child.getDeclaredAnnotation(MyAnnotation.class);
        if (myAnnotation == null) {
            System.out.println("无法获取到注解到父类接口的@Inherited注解！");
        }

        //测试注解到方法上是否有效
        Method method = Child.class.getMethod("sayHello", String.class);
        System.out.println("是否能获取注解到子类上方法上的注解：" + method.getAnnotation(MyAnnotation.class) == null);
        System.out.println("是否能获取注解到子类上方法上的注解：" + method.getDeclaredAnnotation(MyAnnotation.class) == null);
    }
}
