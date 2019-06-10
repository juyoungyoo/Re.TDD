package com.this_is_java.chapter16_stream;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};

        System.out.println("[peek()를 마지막에 호출한 경우]");
        Arrays.stream(intArray)
                .peek(num -> System.out.println(num));

        System.out.println();
        System.out.println("[최종 처리 메소드를 마지막에 호출한 경우]");
        int total = Arrays.stream(intArray)
                .peek(num -> System.out.print(num + ", "))
                .sum();
        System.out.println("\n총합 : " + total);

        System.out.println();
        System.out.println("[forEach()를 마지막에 호출한 경우]");
        Arrays.stream(intArray)
                .filter(num -> num%2 == 0)
                .forEach(num -> System.out.print(num + ", "));
    }
}
