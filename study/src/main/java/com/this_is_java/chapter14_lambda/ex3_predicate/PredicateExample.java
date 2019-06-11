package com.this_is_java.chapter14_lambda.ex3_predicate;

import com.this_is_java.chapter14_lambda.ex3_predicate.PredicateExample.Student.Sex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    private static List<Student> students = Arrays.asList(
            new Student("홍길동", Sex.MALE, 90),
            new Student("김순희", Sex.FEMALE, 90),
            new Student("김자바", Sex.MALE, 95),
            new Student("박한나", Sex.FEMALE, 92)
    );
    public static void main(String[] args) {
        // 남자 또는 여자 학생의 평균 점수 출력
        System.out.println(Sex.FEMALE + ": " + avg(s -> s.getSex().equals(Sex.FEMALE)));
        System.out.println(Sex.MALE + ": " + avg(s -> s.getSex().equals(Sex.MALE)));
    }

    private static double avg(Predicate<Student> predicate){
        return students.stream()
                .filter(predicate::test)
                .mapToInt(Student::getScore)
                .average()
                .orElse(0.0);
    }

    static class Student {

        public enum Sex{
            MALE,
            FEMALE
        }

        private final String name;
        private final Sex sex;
        private final int score;

        public Student(String name,
                       Sex sex,
                       int score) {
            this.name = name;
            this.sex = sex;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public Sex getSex() {
            return sex;
        }

        public int getScore() {
            return score;
        }
    }
}
