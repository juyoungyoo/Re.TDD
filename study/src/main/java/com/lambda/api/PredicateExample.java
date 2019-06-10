package com.lambda.api;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    private static List<Student> students = Arrays.asList(
            new Student("A", "남자", 90),
            new Student("B", "여자", 40),
            new Student("C", "여자", 50),
            new Student("D", "남자",70));

    public double avg(Predicate<Student> predicate) {
        int count = 0;
        int sum = 0;
        for (Student student : students) {
            if(predicate.test(student)){
                count ++;
                sum += student.getScore();
            }
        }
        return sum/count;
    }
}

@Getter
@Setter
class Student{
    private String name;
    private String sex;
    private int score;

    public Student(String name,
                   String sex,
                   int score) {
        this.name = name;
        this.sex = sex;
        this.score = score;
    }
}
