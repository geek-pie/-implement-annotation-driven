package com.bscoder.annotation.chapter9;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


/**
 * @author bscoder
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(EnableCarImportRegister.class)
public @interface EnableCar {
    /**
     * 指定本次的驾驶车辆品牌
     *
     * @return
     */
    String brand();
    /**
     * 指定本次的驾驶车辆的生产年限
     *
     * @return
     */
    int year();
    /**
     * 指定本次的驾驶车辆的产地
     *
     * @return
     */
    String make();
}
