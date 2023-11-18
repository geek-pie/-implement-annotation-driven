package com.bscoder.annotation.aop.common;

import com.bscoder.annotation.common.Logging;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年08月17日 11:30
 */
public interface HelloService {

    @Logging(id = "StringService.hello")
    String hello(String name);
}
