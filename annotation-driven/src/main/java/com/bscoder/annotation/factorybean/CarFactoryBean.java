package com.bscoder.annotation.factorybean;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月07日 14:16
 */

public class CarFactoryBean implements FactoryBean<Car>, InitializingBean {

    private Map<String, Car> carMap = new ConcurrentHashMap<>();

    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public CarFactoryBean() {
        carMap.put("BYD", new BYDCar());
        carMap.put("BMW", new BMWCar());
    }

    @Override
    public Car getObject() {
        return carMap.get(brand);
    }

    @Override
    public Class<Car> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CarFactoryBean afterPropertiesSet !");
    }
}
