package com.tdd.baseballgame.model.result;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersResultTest {

    @Test
    public void strike_count_two() {
        NumbersResult numbersResult = new NumbersResult(Arrays.asList(ResultType.STRIKE, ResultType.STRIKE, ResultType.BALL));
        assertThat(numbersResult.countStrike()).isEqualTo(2);
    }
}