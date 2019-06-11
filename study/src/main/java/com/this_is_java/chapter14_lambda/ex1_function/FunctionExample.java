package com.this_is_java.chapter14_lambda.ex1_function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

/**
 * printString : function<Student ,String>
 * printInt : toIntFunction<Student>
 */
public class FunctionExample {
    private static List<Student> students = Arrays.asList(
      new Student("홍길동", 90, 96),
      new Student("신용권", 95, 93)
    );

    public static void main(String[] args) {
        printString(t->t.getName());
        printInt(t->t.getMathScore());
        printInt(t->t.getEnglishScore());
    }

    private static void printString(Function<Student, String> function){
        for (Student student : students) {
            System.out.println(function.apply(student));
        }
        System.out.println();
    }
    private static void printInt(ToIntFunction<Student> function){
        for (Student student : students) {
            System.out.println(function.applyAsInt(student));
        }
        System.out.println();
    }


}
