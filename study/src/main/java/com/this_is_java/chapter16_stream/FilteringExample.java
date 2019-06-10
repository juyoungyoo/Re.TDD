package com.this_is_java.chapter16_stream;

import java.util.Arrays;
import java.util.List;

public class FilteringExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("홍길동", "신용권", "김자바", "신용권", "신민철");
        names.stream()
                .distinct()
                .filter(name -> name.startsWith("신"))
                .forEach(name -> System.out.println(name));
    }
}
