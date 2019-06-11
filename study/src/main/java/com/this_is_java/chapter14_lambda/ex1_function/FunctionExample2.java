package com.this_is_java.chapter14_lambda.ex1_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

/**
 * 영어, 수학 점수의 평균값을 산출한다.
 * avg(ToIntFunction<Student/>)
 * getEnglishScore()
 * getMathScore()
 * Student 객체 변환
 */
public class FunctionExample2 {
    private static List<Student> students = Arrays.asList(
            new Student("홍길동", 90, 96),
            new Student("신용권", 95, 93)
    );

    private static double avg(ToIntFunction<Student> function){
        int sum = 0;
        for (Student student : students) {
            sum += function.applyAsInt(student);
        }
        return (double) sum / students.size();
    }

    public static void main(String[] args) {
        double mathAvg = avg(Student::getMathScore);
        double englishAvg = avg(Student::getEnglishScore);
        System.out.println(englishAvg);
        System.out.println(mathAvg);
    }
}
