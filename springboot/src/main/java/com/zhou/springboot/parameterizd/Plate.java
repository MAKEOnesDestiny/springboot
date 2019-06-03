package com.zhou.springboot.parameterizd;

public class Plate<T> {

    public static void main(String[] args) {
        Plate<Apple> plate = new Plate<>();
        plate.getClass().getGenericInterfaces();
        System.out.println();
    }
}
