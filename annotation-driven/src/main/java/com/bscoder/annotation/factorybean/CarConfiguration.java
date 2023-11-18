package com.bscoder.annotation.factorybean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月07日 15:40
 */

@Configuration
@ComponentScan(basePackages = {"com.codeland.annotation.factorybean"})
public class CarConfiguration {
//
//    @Bean("BMW")
//    public CarFactoryBean BMWFactoryBean() {
//        CarFactoryBean cfb = new CarFactoryBean();
//        cfb.setMake("BMW");
//        cfb.setYear(1984);
//        return cfb;
//    }
//
//    @Bean("BENZ")
//    public CarFactoryBean BENZFactoryBean() {
//        CarFactoryBean cfb = new CarFactoryBean();
//        cfb.setMake("BENZ");
//        cfb.setYear(1986);
//        return cfb;
//    }
}
