package com.this_is_java.chapter16_stream;

import com.this_is_java.chapter16_stream.Student.City;
import com.this_is_java.chapter16_stream.Student.Sex;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.System.out;

/**
 * 거주 도시를 key 로 갖고, 학생 이름을 Value 로 갖는 Map 생성
 * hint! Collectors.groupingBy(Function<T,K> classifier, Collector<T,A,D> collector) 사용
 */
public class GroupingByExample {

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("홍길동", 10, Sex.MALE, City.SEOUL),
                new Student("김수애", 6, Sex.FEMALE, City.BUSAN),
                new Student("신용권", 10, Sex.MALE, City.BUSAN),
                new Student("박수미", 6, Sex.FEMALE, City.SEOUL)
        );

        // 성별로 grouping
        Map<Sex, List<Student>> sexListMap = students.stream()
                .collect(Collectors.groupingBy(Student::getSex));
        out.println("[남학생]");
        sexListMap.get(Sex.MALE)
                .forEach(student -> out.println(student.getName()));


        sexListMap.get(Sex.MALE)
                .stream()
                .forEach(student -> out.println(student.getName()));

        out.println();

        // 거주 도시를 key 로 갖고, 학생 이름을 Value 로 갖는 Map 생성
        Map<City, List<String>> cityListMap = students.stream()
                .collect(Collectors.groupingBy(
                        student -> student.getCity(),
                        Collectors.mapping(Student::getName, Collectors.toList())
                        /* mapping(Function<T,U> mapper, Collector<U,A,R> collector) : T를 U로 mapping 후, U를 R에 수집
                           return Collector<T,R>
                        */

                ));


        // 동일
        Map<City, List<String>> cityListMap2 = new HashMap<>();
        for (Student student : students) {
            String name = student.getName();
            cityListMap.computeIfAbsent(student.getCity(), k -> new ArrayList<>()).add(name);
        }

        out.println("서울");
        cityListMap.get(City.SEOUL)
                .stream()
                .forEach(s -> out.println(s));
    }
}
