package com.bscoder.annotation.factorybean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author xujianxing@sensetime.com
 * @Description:
 * @date 2023年01月08日 22:18
 */
@Component
public class Driver {

    private String name;

    @Autowired
    private Car car;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
