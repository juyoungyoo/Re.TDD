package com.tdd.baseballgame.model.result;

import com.tdd.baseballgame.model.Numbers;

import java.util.*;

public class AnswerResult {

    private static final int ANSWER_TURN_MAX = 9;
    private static int answerTurn;
    private NumbersResult numbersResult;

    public AnswerResult(NumbersResult numbersResult) {
        answerTurn++;
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

    public static int getAnswerTurn() {
        return answerTurn;
    }

    public boolean isGameOver() {
        return answerTurn == ANSWER_TURN_MAX;
    }
}
