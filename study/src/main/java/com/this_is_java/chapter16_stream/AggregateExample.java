package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.Optional;

/**
 * 개수, 합, 평균, 최대값, 최소값
 * 첫번째 3의 배수
 */
public class AggregateExample {

    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        System.out.println("[2의 배수 개수]");
        long count = Arrays.stream(intArr).count();
        System.out.println("결과 : " + count);

        System.out.println("\n[2의 배수 합]");
        int total = Arrays.stream(intArr).sum();
        System.out.println("결과 : " + total);

        System.out.println("\n[2의 배수의 평균]");
        double average = Arrays.stream(intArr)
                .average()
                .getAsDouble();
        System.out.println("결과 : " + average);

        System.out.println("\n[최대값]");
        int max = Arrays.stream(intArr)
                .max()
                .getAsInt();
        System.out.println("결과 : " + max);

        System.out.println("\n[최소값]");
        int min = Arrays.stream(intArr)
                .min()
                .getAsInt();
        System.out.println("결과 : " + min);

        System.out.println("\n[첫번째 3의 배수]");
        int first = Arrays.stream(intArr)
                .filter(num -> num % 3 == 0)
                .findFirst()
                .getAsInt();
        System.out.println("결과 : " + first);
    }
}
