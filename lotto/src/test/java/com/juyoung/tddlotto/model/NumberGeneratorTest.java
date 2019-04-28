package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    public void 랜덤한_당첨번호_생성한다() {
        WinningLotto winningLotto = NumberGenerator.getWinningLotto();
        assertThat(winningLotto.getLotto().size()).isEqualTo(6);
        assertThat(winningLotto.getBonus()).isNotNull();
    }
}