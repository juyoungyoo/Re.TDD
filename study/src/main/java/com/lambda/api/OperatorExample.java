package com.lambda.api;

import java.util.function.IntBinaryOperator;

public class OperatorExample {

    public int[] scores = {92, 95, 100};

    public int minOrMax(IntBinaryOperator operator) {
        int result = scores[0];
        for (Integer score : scores) {
            result = operator.applyAsInt(result, score);
        }
        return result;
    }
}