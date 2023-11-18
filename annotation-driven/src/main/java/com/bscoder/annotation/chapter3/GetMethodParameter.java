package com.bscoder.annotation.chapter3;

import java.lang.annotation.*;
import java.lang.reflect.Method;


public class GetMethodParameter {

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation {
    }

    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MyAnnotation2 {
    }


    public void myMethod(@MyAnnotation @MyAnnotation2 String arg1, @MyAnnotation2 int arg2) {

    }

    public static void main(String[] args) throws Exception {
        Method method = GetMethodParameter.class.getMethod("myMethod", String.class, int.class);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotations = parameterAnnotations[i];
            for (Annotation annotation : annotations) {
                System.out.println("InheritedAnnotationTest on parameter " + (i + 1) + ": " + annotation);
            }
        }
    }
}



