package com.this_is_java.chapter14_lambda.ex2_operator;

import java.util.function.IntBinaryOperator;

public class OperatorExample {
    private static int[] scores = {92, 95, 87};

    public static void main(String[] args) {
        int min = maxOrMin(Math::min);
        System.out.println(min);
        int max = maxOrMin(Math::max);
        System.out.println(max);
    }

    private static int maxOrMin(IntBinaryOperator operator) {
        int result = scores[0];
        for (int score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }

}
