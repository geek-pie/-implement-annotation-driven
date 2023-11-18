package com.bscoder.annotation.factorybean;

/**
 * @author xujianxing@sensetime.com
 * @Description: TODO
 * @date 2023年01月07日 14:15
 */
public class Car {

    protected String make;

    protected int year;

    protected String brand;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", year=" + year +
                ", brand='" + brand + '\'' +
                '}';
    }
}
