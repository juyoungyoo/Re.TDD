package com.this_is_java.chapter14_lambda.ex4_predicate_default_method;

import java.util.function.IntPredicate;

/**
 * Predicate default method : or(), and(), negate()
 * 2의 배수 검사
 * 3의 배수 검사
 * 9는 2와 3의 배수인가? false
 * 9는 2또는 3의 배수인가? true
 * 9는 홀수인가? true
 */
public class PredicateAndOrNegateExample {
    public static void main(String[] args) {

        // 2의 배수
        IntPredicate multipleOfTwo = value -> value % 2 == 0;
        // 3의 배수
        IntPredicate multipleOfThree = value -> value % 3 == 0;

        // 9는 2와 3의 배수인가?
        boolean result = multipleOfTwo.and(multipleOfThree).test(9);
        System.out.println("9는 2와 3의 배수인가? " + result);
        // 9는 2또는 3의 배수인가?
        boolean orResult = multipleOfTwo.or(multipleOfThree).test(9);
        System.out.println("9는 2또는 3의 배수인가? " + orResult);

        // 9는 홀수인가?
        boolean negateResult = multipleOfTwo.negate().test(9);
        System.out.println("9는 홀수인가? " + negateResult);
    }
}
