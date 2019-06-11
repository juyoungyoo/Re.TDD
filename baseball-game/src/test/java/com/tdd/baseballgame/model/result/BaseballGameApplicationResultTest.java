package com.tdd.baseballgame.model.result;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseballGameApplicationResultTest {


    @Test
    public void 결과값을_반환한다() {
        List<AnswerResult> answerResults = Arrays.asList(answerResultOf(1, ResultType.STRIKE, ResultType.BALL, ResultType.BALL));
        BaseballGameSummary baseballGameSummary = new BaseballGameSummary(answerResults);

        assertThat(baseballGameSummary.getCount(ResultType.BALL)).isEqualTo(2);
        assertThat(baseballGameSummary.getCount(ResultType.STRIKE)).isEqualTo(1);
    }

    @Test
    public void 두개의_누적된_결과값을_반환한다() {
        List<AnswerResult> answerResults = Arrays.asList(
                answerResultOf(1, ResultType.STRIKE, ResultType.BALL, ResultType.BALL),
                answerResultOf(2, ResultType.OUT, ResultType.BALL, ResultType.BALL)
        );
        BaseballGameSummary baseballGameSummary = new BaseballGameSummary(answerResults);

        assertThat(baseballGameSummary.getCount(ResultType.BALL)).isEqualTo(4);
        assertThat(baseballGameSummary.getCount(ResultType.STRIKE)).isEqualTo(1);
        assertThat(baseballGameSummary.getCount(ResultType.OUT)).isEqualTo(1);
    }

    @Test
    public void 볼이_나온_확률을_반환한다() {
        double expected = (double) 4 / 6 * 100;
        List<AnswerResult> answerResults = getAnswerResults(
                answerResultOf(1, ResultType.STRIKE, ResultType.BALL, ResultType.BALL),
                answerResultOf(2, ResultType.OUT, ResultType.BALL, ResultType.BALL)
        );
        BaseballGameSummary baseballGameSummary = new BaseballGameSummary(answerResults);

        assertThat(baseballGameSummary.getPercent(ResultType.BALL)).isEqualTo(expected);
    }

    @Test
    public void 매칭률이_100일_때와_0일때_에러확인한다() {
        List<AnswerResult> answerResults = Arrays.asList(answerResultOf(1, ResultType.STRIKE, ResultType.STRIKE, ResultType.STRIKE));
        BaseballGameSummary baseballGameSummary = new BaseballGameSummary(answerResults);

        assertThat(baseballGameSummary.getPercent(ResultType.STRIKE)).isEqualTo(100);
        assertThat(baseballGameSummary.getPercent(ResultType.BALL)).isEqualTo(0);
    }


    private List<AnswerResult> getAnswerResults(AnswerResult... answerResults) {
        return Arrays.asList(answerResults);
    }

    private AnswerResult answerResultOf(int tryCount,
                                        ResultType... resultTypes) {
        return new AnswerResult(tryCount, getNumbersResult(resultTypes));
    }

    private NumbersResult getNumbersResult(ResultType... resultTypes) {
        return new NumbersResult(Arrays.asList(resultTypes));
    }
}