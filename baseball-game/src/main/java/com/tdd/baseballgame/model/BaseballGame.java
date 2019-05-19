package com.tdd.baseballgame.model;

import com.tdd.baseballgame.model.result.AnswerResult;
import com.tdd.baseballgame.model.result.BaseballGameSummary;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class BaseballGame {

    private Numbers answer;
    private List<AnswerResult> answerResults;

    public BaseballGame(Numbers answer) {
        this.answerResults = new ArrayList<>();
        this.answer = answer;
    }

    public AnswerResult ask(Numbers numbers) {
        AnswerResult answerResult = new AnswerResult(answerResults.size() + 1, this.answer.result(numbers));
        answerResults.add(answerResult);
        return answerResult;
    }

    public BaseballGameSummary summaryResultType(){
        return new BaseballGameSummary(answerResults);
    }

}
