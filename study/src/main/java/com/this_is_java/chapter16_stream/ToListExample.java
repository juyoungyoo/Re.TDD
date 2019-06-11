package com.this_is_java.chapter16_stream;

import com.this_is_java.chapter16_stream.Student.Sex;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *  최종 처리 Collect() 연습문제
 *  1. 남학생만 묶어 List 생성
 *  2. 여학생만 묶어 Set 생성
 */
public class ToListExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10, Sex.MALE),
                new Student("김수애", 6, Sex.FEMALE),
                new Student("신용권", 10, Sex.MALE),
                new Student("박수미", 6, Sex.FEMALE)
        );

        // 남학생만 묶어 List 생성
        List<Student> males = students.stream()
                .filter(student -> student.getSex() == Sex.MALE)
                .collect(Collectors.toList());
        males.forEach(male -> System.out.println(male.getName()));
        boolean result = males.stream()
                .allMatch(student -> student.getSex() == Sex.MALE);
        System.out.println("모두 남자인가? " + result);

        // 여학생만 묶어 Set 생성
        Set<Student> females = students.stream()
                .filter(student -> student.getSex() == Sex.FEMALE)
                .collect(Collectors.toSet());
        females.stream().forEach(female-> System.out.println(female.getName()));
        System.out.println("모두 여자인가? " + females.stream().allMatch(student -> student.getSex() == Sex.FEMALE));

    }
}
