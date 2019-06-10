package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.List;

/**
 * 학생 점수를 요소로 하는 새로운 스트림 생성 후 점수를 순차적으로 콘솔에 출력
 * -------------
 * output
 * -------------
 * 10
 * 20
 * 30
 * -------------
 * */
public class MapExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10),
                new Student("신용권", 20),
                new Student("유미선", 30)
        );

        students.stream()
                .mapToInt(student -> student.getScore())
                .forEach(score -> System.out.println(score));

        int totalScore = students.stream()
                .mapToInt(student -> student.getScore())
                .sum();
        System.out.println("총합: " + totalScore);
    }


}
