package com.bscoder.annotation.importSelector;

import com.bscoder.annotation.factorybean.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月08日 22:19
 */

@EnableCar(brand = "BMW", make = "china", year = 2023)
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        Car car = applicationContext.getBean(Car.class);
        System.out.println(car);
    }
}
