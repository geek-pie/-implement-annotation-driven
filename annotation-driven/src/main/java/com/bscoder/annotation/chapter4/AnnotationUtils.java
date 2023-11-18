package com.bscoder.annotation.chapter4;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年04月23日 16:42
 */
public class AnnotationUtils {

    public static <A extends Annotation> A[] findAnnotation(AnnotatedElement element, Class<A> annotationType) {
        A[] result = getAnnotation(element, annotationType);
        if (result != null) {
            return result;
        }
        if (element instanceof Class) {
            Class<?> clazz = (Class<?>) element;
            // 搜索指定类的父接口
            for (Class<?> ifc : clazz.getInterfaces()) {
                result = findAnnotation(ifc, annotationType);
                if (result != null) {
                    return result;
                }
            }
            // 搜索父类
            Class<?> superclass = clazz.getSuperclass();
            if (superclass != null && Object.class != superclass) {
                result = findAnnotation(superclass, annotationType);
                if (result != null) {
                    return result;
                }
            }
        }
        if (element instanceof Method) {
            Method method = (Method) element;
            //查询父接口
            Class<?>[] ifcs = method.getDeclaringClass().getInterfaces();
            for (Class<?> iface : ifcs) {
                try {

                    Method candidateMethod = findBridgeMethod(method);
                    Method equivalentMethod = iface.getMethod(candidateMethod.getName(), candidateMethod.getParameterTypes());
                    result = findAnnotation(equivalentMethod, annotationType);
                    if (result != null) {
                        return result;
                    }
                } catch (NoSuchMethodException ex) {
                    // 如果找不到方法，就直接跳过
                }
            }
            Class<?> clazz = method.getDeclaringClass().getSuperclass();
            if (clazz == null || Object.class == clazz) {
                return null;
            }
            try {
                Method candidateMethod = findBridgeMethod(method);
                Method equivalentMethod = clazz.getDeclaredMethod(candidateMethod.getName(), candidateMethod.getParameterTypes());
                result = findAnnotation(equivalentMethod, annotationType);
                if (result != null) {
                    return result;
                }
            } catch (NoSuchMethodException ex) {
                // 如果找不到方法，就直接跳过
            }
        }
        return null;
    }

    public static Method findBridgeMethod(Method method) {
        if (method.isBridge()) {
            return method;
        }
        Method[] methods = method.getDeclaringClass().getDeclaredMethods();
        for (Method candidateMethod : methods) {
            if (candidateMethod.isBridge()) {
                if (candidateMethod.getName().equals(method.getName()) && candidateMethod.getParameterCount() == method.getParameterCount()) {
                    return candidateMethod;
                }
            }
        }
        return method;
    }


    private static <A extends Annotation> A[] getAnnotation(AnnotatedElement element, Class<A> annotationType) {
        A[] result = element.getAnnotationsByType(annotationType);
        if (result != null && result.length > 0) {
            return result;
        }
        return null;
    }
}