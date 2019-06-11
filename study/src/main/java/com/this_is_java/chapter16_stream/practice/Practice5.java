package com.this_is_java.chapter16_stream.practice;

import java.util.Arrays;
import java.util.List;

/**
 * 대소문자 상관없이 "java" 단어 포함된 문자열 추출
 */
public class Practice5 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "This is a java book",
                "Lambda Expressions",
                "Java8 supports lambda expressions"
        );

        list.stream()
                .filter(str-> str.toLowerCase().contains("java"))
                .forEach(str-> System.out.println(str));
    }
}
