package com.bscoder.annotation.chapter1;

import java.lang.annotation.*;


/**
 * @author xujianxing
 */
public class AnnotationTest {

    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.METHOD, ElementType.TYPE})
    public @interface Tweezable {
        String id() default "";
    }

    @Tweezable(id = "AnnotationProcessService")
    public static class AnnotationProcessService<T extends Annotation> {
        private T annotation;

        public AnnotationProcessService(T annotation) {
            this.annotation = annotation;
        }

        public T getAnnotation() {
            return annotation;
        }
        public static void main(String[] args) {
            Tweezable myAnnotation = AnnotationProcessService.class.getAnnotation(Tweezable.class);
            //直接调用注解的方法
            System.out.println(myAnnotation.id());

            //注解作为参数传递，并且可以用作泛型类型
            AnnotationProcessService<Tweezable> annotationProcessService = new AnnotationProcessService(myAnnotation);

            //判断实际的注解类型
            System.out.println(annotationProcessService.getAnnotation() instanceof Tweezable);
            System.out.println(annotationProcessService.getAnnotation() instanceof Annotation);
        }

    }
}
