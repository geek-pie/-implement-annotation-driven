package com.bscoder.annotation.chapter7;


import org.springframework.core.annotation.AnnotatedElementUtils;

import java.lang.annotation.*;
import java.util.Set;

@FindMergedAnnotationTest.Schedule(dayOfWeek = "1")
@FindMergedAnnotationTest.Schedule(dayOfWeek = "2")
@FindMergedAnnotationTest.Schedule(dayOfHour = 3)
@FindMergedAnnotationTest.Schedule(dayOfMonth = "4")
public class FindMergedAnnotationTest {


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
        Set<Schedule> schedule = AnnotatedElementUtils.findAllMergedAnnotations(FindMergedAnnotationTest.class, Schedule.class);
        System.out.println(schedule.size());
        schedule = AnnotatedElementUtils.getAllMergedAnnotations(FindMergedAnnotationTest.class, Schedule.class);
        System.out.println(schedule.size());
        Set<Schedules> schedules = AnnotatedElementUtils.getAllMergedAnnotations(FindMergedAnnotationTest.class, Schedules.class);

        System.out.println(schedules.size());
        schedules = AnnotatedElementUtils.findAllMergedAnnotations(FindMergedAnnotationTest.class, Schedules.class);
        System.out.println(schedules.size());

    }


}
