package com.this_is_java.chapter16_stream.practice;

import java.util.Arrays;
import java.util.List;

/**
 * Member 평균나이 출력
 */
public class Practice6 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 30),
                new Student("신용권", 40),
                new Student("김자바", 26)
        );

        double average = students.stream()
                .mapToInt(Student::getAge)
                .average()
                .orElse(0.0);
        System.out.println(average);
    }

    private static class Student {
        private final String name;
        private final int age;

        public Student(String name,
                       int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
