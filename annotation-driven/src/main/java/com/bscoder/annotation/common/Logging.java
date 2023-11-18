package com.bscoder.annotation.common;

import java.lang.annotation.*;

@Inherited
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Logging {

    /**
     * 唯一ID，方便区分在哪里打印的日志
     *
     * @return
     */
    String id() default "";
}
