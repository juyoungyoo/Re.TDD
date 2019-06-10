package com.tdd.baseballgame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DigitTest {

    @Test
    public void 숫자_싱글톤_확인() {
        assertThat(Digit.of(0)).isEqualTo(Digit.of(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void MIN보다_작은_수_생성시_실패한다() {
        Digit.of(Digit.MIN - 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void MAX보다_큰_수_생성하면_실패한다() {
        Digit.of(Digit.MAX + 1);
    }
}