package com.bscoder.annotation.chapter3;

import com.bscoder.annotation.common.Logging;

/**
 * @author xujianxing@sensetime.com
 * @date 2023年06月25日 22:11
 */
public class LocalClassTest {
    @Logging(id = "OuterClass")
    static public class OuterClass {
        private int outerVar = 10;

        public void outerMethod() {
            int localVar = 5;

            // Local class
            class LocalClass {
                public void display() {
                    outerVar = 20;
                    System.out.println("Outer variable: " + outerVar);
                    System.out.println("Local variable: " + localVar);
                    System.out.println(LocalClass.class.getEnclosingClass().getAnnotation(Logging.class).id());
                }
            }

            // 创建局部类实例并调用方法
            LocalClass localObj = new LocalClass();
            localObj.display();

        }
    }

    public static void main(String[] args) {
        new OuterClass().outerMethod();
    }
}
