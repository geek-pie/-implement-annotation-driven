package com.bscoder.annotation.chapter9;

import com.bscoder.annotation.chapter9.EnableCar;
import com.bscoder.annotation.factorybean.Car;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月19日 21:03
 */
public class EnableCarImportRegister implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        Map<String, Object> map = importingClassMetadata.getAnnotationAttributes(EnableCar.class.getName(), false);
        if (map == null) {
            return;
        }
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(map);
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(Car.class);
        builder.addPropertyValue("brand", attributes.getString("brand"));
        builder.addPropertyValue("make", attributes.getString("make"));
        builder.addPropertyValue("year", attributes.getNumber("year"));
        registry.registerBeanDefinition("car", builder.getBeanDefinition());
    }

}
