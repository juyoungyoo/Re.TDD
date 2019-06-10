package com.tdd.baseballgame.io;

import com.tdd.baseballgame.model.BaseballGame;
import com.tdd.baseballgame.model.Digit;
import com.tdd.baseballgame.model.Numbers;
import com.tdd.baseballgame.model.result.AnswerResult;
import com.tdd.baseballgame.model.result.ResultType;

import java.util.List;
import java.util.Map;

public class OutputConsole {

    public static void answer(BaseballGame baseballGame) {
        Numbers numbers = baseballGame.getAnswer();
        List<Digit> digits = numbers.getDigits();
        System.out.println("------------------------");
        System.out.print("DIGIT : ");
        for (Digit digit : digits) {
            System.out.print(digit.getNumber() + " ");
        }
        System.out.println("\n------------------------");
    }

    public static void result(AnswerResult answerResult) {
        System.out.println("------------------------");
        System.out.println("TURN [" + answerResult.getTryCount() + "]");
        Map<ResultType, Integer> result = answerResult.getResult();
        for(Map.Entry<ResultType, Integer> resultType : result.entrySet()){
            System.out.println(resultType.getKey() + ": "+ resultType.getValue());
        }
        System.out.println("------------------------");
    }

    public static void summary(BaseballGame baseballGame, String message) {
        System.out.println(message);
        System.out.println("------------------------");
        for (ResultType resultType : ResultType.values()) {
            System.out.println(resultType + ": " + baseballGame.summaryResultType().getCount(resultType) + " / " + baseballGame.summaryResultType().getPercent(resultType));
        }
        System.out.println("------------------------");
    }
}
