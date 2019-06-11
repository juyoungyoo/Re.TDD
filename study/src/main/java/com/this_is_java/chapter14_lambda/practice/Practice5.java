package com.this_is_java.chapter14_lambda.practice;

import java.util.function.IntBinaryOperator;

public class Practice5 {
    private static int[] scores = {10, 50, 3};

    public static int maxOrMin(IntBinaryOperator binaryOperator){
        int result = scores[0];
        for (int score : scores) {
            result = binaryOperator.applyAsInt(result, score);
        }
        return result;
    }

    public static void main(String[] args) {

        // 최대값 얻기
        System.out.println("최대값: " + maxOrMin(Math::max));
        // 최소값 얻기
        System.out.println("최소값: " + maxOrMin(Math::min));
    }
}
