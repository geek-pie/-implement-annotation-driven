package com.bscoder.annotation.chapter3;


import com.bscoder.annotation.common.Logging;

public class EnclosingClassTest {

    @Logging(id = "OuterClass")
    static class OuterClass {
        private int outerVar;

        class InnerClass {
            private int innerVar;

            public InnerClass() {
                // 访问外部类的成员变量
                outerVar = 5;
                innerVar = 10;
            }

            public void display() {
                System.out.println("Outer variable: " + outerVar);

                System.out.println("Inner variable: " + innerVar);
            }
        }

        public void createInner() {
            // 创建内部类实例
            InnerClass inner = new InnerClass();
            inner.display();
            System.out.println("InnerClass的EnclosingClass为:" + inner.getClass().getEnclosingClass().getName());
            //使用EnclosingClass.this
            System.out.println("InnerClass的EnclosingClass为: " + OuterClass.this.getClass().getName());
            System.out.println("InnerClass的EnclosingClass的Logging注解" + inner.getClass().getEnclosingClass().getAnnotationsByType(Logging.class)[0].id());
        }
    }

    public static void main(String[] args) {
        new OuterClass().createInner();
    }
}
