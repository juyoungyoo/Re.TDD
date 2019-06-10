package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.List;

// todo : Operator study

/**
 *  점수 합계 구하기
 *  1. 집계 처리 메소드 이용 : sum()
 *  2-1. 커스텀 집계 이용 : reduce(BinaryOperator<Integer> op)
 *  2-2. 커스텀 집계 이용 : reduce(int identity, IntBinaryOperator op)
 */
public class ReductionExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 92),
                new Student("신용권", 95),
                new Student("유미선", 88)
        );

        // 1. 집계 처리 메소드 이용 : sum()
        int sum = students.stream()
                .mapToInt(Student::getScore)
                .sum();
        System.out.println("결과 : " + sum);

        Integer integer1 = students.stream()
                .map(Student::getScore)
                .reduce((a, b) -> a + b)
                .get();
        System.out.println("결과 : " + integer1);

        int integer2 = students.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);
        System.out.println("결과 : " + integer2);


    }
}
