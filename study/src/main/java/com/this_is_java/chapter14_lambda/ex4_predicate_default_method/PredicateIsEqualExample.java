package com.this_is_java.chapter14_lambda.ex4_predicate_default_method;

import java.util.function.Predicate;

public class PredicateIsEqualExample {
    public static void main(String[] args) {

        Predicate<String> predicate;

        // null, null 비교
        predicate = Predicate.isEqual(null);
        boolean result = predicate.test(null);
        System.out.println("null, null 비교 : " + result);

        System.out.println("===============================");

        // java8
        predicate = Predicate.isEqual("java8");
        result = predicate.test(null);
        System.out.println(result);
        result = predicate.test("java8");
        System.out.println(result);
        result = predicate.test("java7");
        System.out.println(result);
    }
}
