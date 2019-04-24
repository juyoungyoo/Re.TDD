package com.juyoung.tddlotto.model.ball;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    public void 로또번호를_6개를_반환한다() {
        int peekCount = 6;
        NumberGenerator lottoNumbers = NumberGenerator.of();
        assertThat(lottoNumbers.size()).isEqualTo(peekCount);
    }
}