package com.tdd.baseballgame.model;

import com.tdd.baseballgame.model.result.ResultType;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultTypeTest {

    @Test
    public void 결과확인() {
        assertResult(true, false, ResultType.BALL);
        assertResult(true, false, ResultType.BALL);
        assertResult(true, false, ResultType.BALL);
        assertThat(resultTypeOf(true, true)).isEqualTo(ResultType.STRIKE);
        assertThat(resultTypeOf(true, false)).isEqualTo(ResultType.BALL);
        assertThat(resultTypeOf(false, false)).isEqualTo(ResultType.OUT);
    }

    private void assertResult(boolean isContainNu,
                              boolean isMatch,
                              ResultType expected) {
        assertThat(ResultType.of(isContainNu, isMatch)).isEqualTo(expected);
    }

    private ResultType resultTypeOf(boolean isContainNumber, boolean isMatchLocation) {
        return ResultType.of(isContainNumber, isMatchLocation);
    }
}