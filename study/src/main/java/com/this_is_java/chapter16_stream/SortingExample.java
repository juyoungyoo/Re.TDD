package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 숫자 요소일 경우 오름차순 정렬 후 print
 * Student 요소일 경우 Stduent의 기본 비교 방법을 이용하여 점수 기준으로 오름차순으로 정렬 출력
 * Comparator 제공하여 점수기준으로 내림차순 출력
 */
public class SortingExample {

    public static void main(String[] args) {
        IntStream intStream = Arrays.stream(new int[]{5, 3, 2, 1, 4});
        intStream
                .sorted()
                .forEach(num -> System.out.print(num + ","));

        System.out.println("\n==================================");
        // 객체 요소일 경우
        List<Student> students = Arrays.asList(
                new Student("유미선", 30),
                new Student("홍길동", 10),
                new Student("신용권", 20)
        );
        students.stream()
                .sorted()
                .mapToInt(student -> student.getScore())
                .forEach(num -> System.out.print(num + ", "));

        System.out.println("\n==================================");
        // 객체 요소일 경우 reverse
        students.stream()
                .sorted(Comparator.reverseOrder())
                .mapToInt(student-> student.getScore())
                .forEach(num -> System.out.print(num + ", "));
    }
}
