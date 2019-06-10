package com.this_is_java.chapter16_stream;

import java.util.Arrays;

/**
 * int[] 배열로 부터 스트림 생성
 * 모든 요소가 2의 배수인지 확인
 * 하나라도 3의 배수가 존재하는지 확인
 * 모든 요소가 3의 배수가 아닌지 확인
 */
public class MatchExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        System.out.println("[모든 요소가 2의 배수인지 확인]");
        boolean allMatch = Arrays.stream(intArr)
                .allMatch(num -> num % 2 == 0);
        System.out.println("결과 : " + allMatch);

        System.out.println("[하나라도 3의 배수가 존재하는지 확인]");
        boolean anyMatch = Arrays.stream(intArr)
                .anyMatch(num -> num % 3 == 0);
        System.out.println("결과 : " + anyMatch);

        System.out.println("[모든 요소가 3의 배수가 아닌지 확인]");
        boolean noneMatch = Arrays.stream(intArr)
                .noneMatch(num -> num % 3 == 0);
        System.out.println("결과 : " + noneMatch);

    }
}
