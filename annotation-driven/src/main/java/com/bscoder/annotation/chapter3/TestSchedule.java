package com.bscoder.annotation.chapter3;


import java.lang.annotation.*;

@TestSchedule.Schedule(dayOfWeek = "1")
@TestSchedule.Schedule(dayOfHour = 1)
@TestSchedule.Schedule(dayOfMonth = "12")
public class TestSchedule {
    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Schedules.class)
    public @interface Schedule {
        String dayOfWeek() default "";

        String dayOfMonth() default "";

        int dayOfHour() default 0;
    }

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Schedules {
        Schedule[] value();
    }


    public static void main(String[] args) {

        System.out.println(TestSchedule.class.getAnnotation(Schedule.class) == null);
        System.out.println(TestSchedule.class.getAnnotationsByType(Schedule.class) == null);
        System.out.println(TestSchedule.class.getDeclaredAnnotationsByType(Schedule.class) != null);
        for (Annotation a:TestSchedule.class.getAnnotations()){
            System.out.println(a.annotationType());
        }
    }
}
