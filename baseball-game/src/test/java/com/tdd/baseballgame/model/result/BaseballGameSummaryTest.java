package com.tdd.baseballgame.model.result;

import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameSummaryTest {

    @Test
    public void answer_success_all_strike() {
        AnswerResult answerResult = getAnswerResult(ResultType.STRIKE, ResultType.STRIKE, ResultType.STRIKE);

        Map<ResultType, Integer> result = answerResult.getResult();

        assertThat(answerResult.isCorrect()).isTrue();
        assertThat(result.get(ResultType.STRIKE)).isEqualTo(3);
    }

    @Test
    public void answer_is_wrong() {
        AnswerResult answerResult = getAnswerResult(ResultType.BALL, ResultType.STRIKE, ResultType.BALL);

        Map<ResultType, Integer> result = answerResult.getResult();

        assertThat(answerResult.isCorrect()).isFalse();
        assertThat(result.get(ResultType.STRIKE)).isEqualTo(1);
        assertThat(result.get(ResultType.BALL)).isEqualTo(2);
    }

    private AnswerResult getAnswerResult(ResultType... resultTypes) {
        NumbersResult numbersResult = new NumbersResult(Arrays.asList(resultTypes));
        return new AnswerResult(1, numbersResult);
    }
}
