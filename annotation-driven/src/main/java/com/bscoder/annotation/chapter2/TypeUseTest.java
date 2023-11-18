package com.bscoder.annotation.chapter2;


import java.lang.annotation.*;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;

@TypeUseTest.NonEmpty
public class TypeUseTest {
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface NonEmpty {
    }

    @NonEmpty
    private String tag;

    @NonEmpty
    public static class Holder<@NonEmpty T> extends Object {
        public void method() throws Exception {
            for (@NonEmpty int i = 0; i < 10; i++) {
            }
        }
    }


    public @NonEmpty TypeUseTest() {


    }

    public static void main(String[] args) throws @NonEmpty Exception {
        final Holder<String> holder = new @NonEmpty Holder<>();
        @NonEmpty Collection<@NonEmpty String> strings = new ArrayList<>();
        //尝试通过反射获取注解到声明到类上的注解
        System.out.println(TypeUseTest.class.getAnnotation(NonEmpty.class));

        //尝试获取注解到Holder泛型参数的注解
        TypeVariable<Class<Holder>>[] typeParams = Holder.class.getTypeParameters();
        for (TypeVariable<Class<Holder>> typeParam : typeParams) {
         Annotation[] annotations = typeParam.getAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println(annotation.annotationType());
            }
        }
    }

    /**
     * @NonEmpty无法用于方法上，因为方法上的注解不是类型使用
     */
    public void setTag(@NonEmpty String tag) {
        this.tag = tag;
    }

}
