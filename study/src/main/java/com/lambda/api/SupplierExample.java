package com.lambda.api;

import java.util.Random;
import java.util.function.IntSupplier;

public class SupplierExample {

    public static void main(String[] args) {
        IntSupplier intSupplier = ()->{
            int num = new Random().nextInt(5);
            return num;
        };
        System.out.println(intSupplier.getAsInt());
    }
}
