package com.tdd.baseballgame.model;

import com.tdd.baseballgame.model.result.NumbersResult;
import com.tdd.baseballgame.model.result.ResultType;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class NumbersTest {

    @Test
    public void 세자리의_숫자를_생성한다() {
        Numbers numbers = Numbers.of(1, 2, 3);
        assertThat(numbers.getDigits()).hasSize(3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구분자가_쉼표가_아닐시_에러난다() {
        String input = "1|3|3";
        Numbers.of(input);
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
        Digit digit = Digit.of(2);

        boolean result = numbers.contain(digit);
        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 숫자를_포함하지_않는다() {
        Numbers numbers = Numbers.of(1, 2, 3);
        Digit digit = Digit.of(4);

        boolean result = numbers.contain(digit);
        assertThat(result).isEqualTo(false);
    }

    @Test
    public void 동일한_위치에_동일한_숫자가_존재한다() {
        int index = 1;
        Digit digit = Digit.of(2);
        Numbers numbers = Numbers.of(1, 2, 3);

        boolean result = numbers.match(index, digit);

        assertThat(result).isEqualTo(true);
    }

    @Test
    public void 결과를_반환한다_스트라이크3() {
        NumbersResult expected = getNumberResult(ResultType.STRIKE, ResultType.STRIKE, ResultType.STRIKE);

        NumbersResult resultTypes = Numbers.of(1, 2, 3).result(Numbers.of(1, 2, 3));

        assertThat(resultTypes).isEqualTo(expected);
    }

    @Test
    public void 결과를_반환한다_스트라이크1_볼2() {
        NumbersResult expected = getNumberResult(ResultType.STRIKE, ResultType.BALL, ResultType.BALL);

        NumbersResult resultTypes = Numbers.of(1, 2, 3).result(Numbers.of(1, 3, 2));

        assertThat(resultTypes).isEqualTo(expected);
    }

    @Test
    public void 결과를_반환한다_스트라이크1_아웃2() {
        NumbersResult expected = getNumberResult(ResultType.STRIKE, ResultType.OUT, ResultType.OUT);

        NumbersResult resultTypes = Numbers.of(1, 2, 3).result(Numbers.of(1, 4, 5));

        assertThat(resultTypes).isEqualTo(expected);
    }

    private NumbersResult getNumberResult(ResultType... resultTypes) {
        return new NumbersResult(Arrays.asList(resultTypes));
    }
}

