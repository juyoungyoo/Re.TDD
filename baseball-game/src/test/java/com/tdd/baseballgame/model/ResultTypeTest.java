package com.tdd.baseballgame.model;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ResultTypeTest {

    @Test
    public void 결과확인() {
        assertThat(resultTypeOf(true, true)).isEqualTo(ResultType.STRIKE);
        assertThat(resultTypeOf(true, false)).isEqualTo(ResultType.BALL);
        assertThat(resultTypeOf(false, false)).isEqualTo(ResultType.OUT);
    }

    private ResultType resultTypeOf(boolean isContainNumber, boolean isMatchLocation) {
        return ResultType.of(isContainNumber, isMatchLocation);
    }
}