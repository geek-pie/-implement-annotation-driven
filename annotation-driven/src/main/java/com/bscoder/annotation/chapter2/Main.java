package com.bscoder.annotation.chapter2;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2022年12月26日 16:47
 */
public class Main {


    public static void main(String[] args) {
        @PresentLocalVariable
        String a = "Hello";
        for (@PresentLocalVariable int i = 0; i < 10; i++) {
        }
    }

    public void m(int a) {
        //a不能使用@PresentLocalVariable注解，因为a不是局部变量
        a = 5;
        @PresentLocalVariable int b = 6;
    }
}
