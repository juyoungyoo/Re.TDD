package com.tdd.baseballgame.model.result;

import com.tdd.baseballgame.model.Numbers;

import java.util.*;

public class AnswerResult {

    private static final int MAX_TRY_COUNT = 9;
    private int tryCount;
    private NumbersResult numbersResult;

    public AnswerResult(int tryCount, NumbersResult numbersResult) {
        this.tryCount = tryCount;
        this.numbersResult = numbersResult;
    }

    public boolean isCorrect(){
        return numbersResult.countStrike() == Numbers.SIZE;
    }

    public Map<ResultType, Integer> getResult() {
        Map<ResultType, Integer> resultTypeMap = new HashMap<>();
        for(ResultType resultType : numbersResult.getResultTypes()){
            resultTypeMap.putIfAbsent(resultType, 0);
            resultTypeMap.computeIfPresent(resultType, (ResultType key, Integer value)-> ++value);
        }
        return resultTypeMap;
    }

    public int getTryCount() {
        return tryCount;
    }

    public boolean isGameOver() {
        return tryCount == MAX_TRY_COUNT;
    }
}
