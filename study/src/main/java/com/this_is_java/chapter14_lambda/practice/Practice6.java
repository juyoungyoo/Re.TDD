package com.this_is_java.chapter14_lambda.practice;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 *  영어 평균 점수
 *  수학 평균 점수
 */
public class Practice6 {
    private static Student[] students = {
            new Student("홍길동", 90, 96),
            new Student("신용권", 95, 93)
    };

    // avg method
    public static double avg(ToIntFunction<Student> function){
        return Arrays.stream(students)
                .mapToInt(function)
                .average()
                .orElse(0.0);
    }

    public static void main(String[] args) {
        double englishAvg = avg(Student::getEnglishScore);
        System.out.println("영어 평균 점수: " + englishAvg);

        double mathAvg = avg(Student::getMathScore);
        System.out.println("수학 평균 점수: " + mathAvg);
    }

    static class Student {
        private final String name;
        private final int englishScore;
        private final int mathScore;

        public Student(String name,
                       int englishScore,
                       int mathScore) {
            this.name = name;
            this.englishScore = englishScore;
            this.mathScore = mathScore;
        }

        public String getName() {
            return name;
        }

        public int getEnglishScore() {
            return englishScore;
        }

        public int getMathScore() {
            return mathScore;
        }
    }
}
