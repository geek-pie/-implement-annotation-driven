package com.bscoder.annotation.factorybean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月07日 14:15
 */
@Component("person")
public class Person {

    @Autowired
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


}
