package com.this_is_java.chapter16_stream;

import java.util.Arrays;

/**
 * int[] 배열 -> intStream
 * int -> double return DoubleStream
 * int -> Integer boxing return Stream<Integer>
 */
public class AsDoubleStreamAndBoxedExample {

    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        Arrays.stream(intArray)
                .asDoubleStream()
                .forEach(num -> System.out.println(num));

        System.out.println("=============================");

        Arrays.stream(intArray)
                .boxed()
                .forEach(num -> System.out.println(num.getClass() + ", " + num.intValue() + ", " + num));
    }
}
