package chapter4;

import com.bscoder.annotation.chapter4.AnnotationUtils;

import java.lang.reflect.Method;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年06月18日 18:46
 */
public class BridgeMethodTest {
    public class Parent<T> {
        void set(T t) {
        }

        Number setNumber(Number t) {
            return t;
        }
    }

    public class Child extends Parent<String> {
        @Override
        void set(String str) {
        }

        @Override
        Integer setNumber(Number t) {
            return super.setNumber(t).intValue();
        }
    }

    public static void main(String[] args) {
        Method[] methods = Child.class.getDeclaredMethods();
        System.out.println("Child类方法的个数" + methods.length);
        for (Method method : Child.class.getDeclaredMethods()) {
            System.out.println(method.toGenericString() + "|是否是桥接方法：" + method.isBridge());
            if (!method.isBridge()) {
                System.out.println("对应的桥接方法:" + AnnotationUtils.findBridgeMethod(method));
            }
        }

    }
}


