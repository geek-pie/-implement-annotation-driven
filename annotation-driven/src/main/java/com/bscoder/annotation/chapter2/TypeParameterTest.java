package com.bscoder.annotation.chapter2;

import java.lang.annotation.*;
import java.lang.reflect.TypeVariable;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年04月23日 15:42
 */
public class TypeParameterTest {

    @Target({ElementType.TYPE_PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface NonEmpty {
    }


    public static class Holder<@NonEmpty T> extends Object {
    }


    public static void main(String[] args) {
        TypeVariable<Class<Holder>>[] typeParams = Holder.class.getTypeParameters();
        for (TypeVariable<Class<Holder>> typeParam : typeParams) {
            Annotation[] annotations = typeParam.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        }
    }
}
