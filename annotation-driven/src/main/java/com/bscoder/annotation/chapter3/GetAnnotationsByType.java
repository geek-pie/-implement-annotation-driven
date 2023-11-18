package com.bscoder.annotation.chapter3;


import java.lang.annotation.*;

public class GetAnnotationsByType {

    @Target({ElementType.TYPE, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    @Inherited
    public @interface InheritedAnnotation {
        String name() default "";
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Rules.class)
    public @interface Rule {
        String rule();
    }


    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Rules {
        //容器注解必须包含value方法
        Rule[] value();
    }

    @InheritedAnnotation(name = "Parent")
    public class Parent {

    }

    @InheritedAnnotation(name = "Child")
    @Rule(rule = "Child1")
    @Rule(rule = "Child2")
    public class Child extends Parent {

    }


    public static void main(String[] args) {
        System.out.println(Child.class.getAnnotationsByType(InheritedAnnotation.class).length);
        for (InheritedAnnotation inheritedAnnotation : Child.class.getAnnotationsByType(InheritedAnnotation.class)) {
            System.out.println(inheritedAnnotation);
        }

        System.out.println(Child.class.getAnnotationsByType(Rule.class).length);
        for (Rule inheritedAnnotation : Child.class.getAnnotationsByType(Rule.class)) {
            System.out.println(inheritedAnnotation);
        }
    }
}
