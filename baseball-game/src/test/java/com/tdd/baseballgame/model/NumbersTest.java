package com.tdd.baseballgame.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    public void 세자리의_숫자를_생성한다() {
        Numbers numbers = Numbers.of(1, 2, 3);
        assertThat(numbers.size()).isEqualTo(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자는_중복되면_안된다() {
        Numbers.of(1, 2, 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 세자리_숫자보다_더_많이_생성할_시_실패한다() {
        Numbers.of(1, 2, 3, 4);
    }

    @Test
    public void 숫자를_포함한다() {
        Numbers numbers = Numbers.of(1, 2, 3);
        Number number = Number.of(2);

        boolean result = numbers.contain(number);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 숫자를_포함하지_않는다() {
        Numbers numbers = Numbers.of(1, 2, 3);
        Number number = Number.of(4);

        boolean result = numbers.contain(number);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 동일한_위치에_동일한_숫자가_존재한다() {
        int index = 1;
        Number number = Number.of(2);
        Numbers numbers = Numbers.of(1, 2, 3);

        boolean result = numbers.match(index, number);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 결과를_반환한다_스트라이크3() {
        Numbers numbers =  Numbers.of(1, 2, 3);
        Numbers numbers2 = Numbers.of(1, 2, 3);

        List<ResultType> resultTypes = numbers.result(numbers2);

        assertThat(resultTypes).containsExactly(ResultType.STRIKE,ResultType.STRIKE,ResultType.STRIKE);
    }

    @Test
    public void 결과를_반환한다_스트라이크1_볼2() {
        Numbers numbers =  Numbers.of(1, 2, 3);
        Numbers numbers2 = Numbers.of(1, 3, 2);

        List<ResultType> resultTypes = numbers.result(numbers2);

        assertThat(resultTypes).containsExactly(ResultType.STRIKE,ResultType.BALL,ResultType.BALL);
    }

    @Test
    public void 결과를_반환한다_스트라이크1_아웃2() {
        Numbers numbers =  Numbers.of(1, 2, 3);
        Numbers numbers2 = Numbers.of(1, 4, 5);

        List<ResultType> resultTypes = numbers.result(numbers2);

        assertThat(resultTypes).containsExactly(ResultType.STRIKE,ResultType.OUT,ResultType.OUT);
    }
}

