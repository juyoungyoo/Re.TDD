package com.lambda.api.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class FunctionExample {

    private static List<Student> students = Arrays.asList(
            new Student("chloe", 90, 96),
            new Student("hello", 80,70));

    public static void printString(Function<Student, String> function){
        for (Student student: students) {
            System.out.println(function.apply(student));
        }
    }

    public static void main(String[] args) {
        System.out.println("STUDEND NAME");
        printString(t->t.getName());
        printString(Student::getName);

        System.out.println("ENGLISH SCORE");
        printInt(t->t.getEnglishScore());

        System.out.println("MATH SCORE");
        printInt(Student::getMathScore);
    }

    private static void printInt(ToIntFunction<Student> toIntFunction) {
        for (Student student : students) {
            System.out.println(toIntFunction.applyAsInt(student));
        }
    }
}
