package com.bscoder.annotation.importSelector;

import com.bscoder.annotation.factorybean.BMWCar;
import com.bscoder.annotation.factorybean.BYDCar;
import com.bscoder.annotation.factorybean.Car;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月19日 21:03
 */
public class CarBrandImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(
                importingClassMetadata.getAnnotationAttributes(EnableCar.class.getName()));

        if (annotationAttributes.getString("carBrand").equals("BMW")) {
            return new String[]{BMWCar.class.getName()};
        } else {
            return new String[]{BYDCar.class.getName()};
        }
    }
}
