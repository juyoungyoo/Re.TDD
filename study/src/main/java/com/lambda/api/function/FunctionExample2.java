package com.lambda.api.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class FunctionExample2 {

    private static List<Student> students = Arrays.asList(
            new Student("chloe", 90, 96),
            new Student("hello", 80,70));

    public static void main(String[] args) {

        double englishAvg = avg(Student::getEnglishScore);
        System.out.println("영어 평균 점수 : " + englishAvg);

        double mathAvg = avg(Student::getMathScore);
        System.out.println("수학 평균 점수 : " + mathAvg);

    }

    private static double avg(ToIntFunction<Student> function) {
        double sum = 0;
        for (Student student: students) {
            sum += function.applyAsInt(student);
        }
        return sum/students.size();
    }
}
