package com.this_is_java.chapter16_stream;

import com.this_is_java.chapter16_stream.Student.Sex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GroupingAndReductinoExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10, Sex.MALE),
                new Student("김수애", 12, Sex.FEMALE),
                new Student("신용권", 10, Sex.MALE),
                new Student("박수미", 12, Sex.FEMALE)
        );

        // 성별로 평균점수를 저장하는 Map 얻기
        Map<Sex, Double> sexByAvg = students.stream()
                .collect(
                        Collectors.groupingBy(Student::getSex, Collectors.averagingDouble(Student::getScore))
                );
        System.out.println(Sex.MALE.getKo() + "의 평균값: " + sexByAvg.get(Sex.MALE));
        System.out.println(Sex.FEMALE.getKo() + "의 평균값: " + sexByAvg.get(Sex.FEMALE));


        System.out.println("=======================================");

        // 성별을 쉼표로 구분한 이름을 저장하는 Map 얻기
        Map<Sex, String> sexStringMap = students.stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getSex,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.joining(",")
                                )
                        )
                );
        for (Map.Entry<Sex, String> entry: sexStringMap.entrySet()) {
            System.out.println(entry.getKey().getKo() + ": "+ entry.getValue());
        }
    }
}
