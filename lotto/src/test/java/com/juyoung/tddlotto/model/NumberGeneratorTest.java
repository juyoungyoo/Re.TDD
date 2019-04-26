package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    public void 로또번호_45개를_생성한다() {
        NumberGenerator lottoNumbers = NumberGenerator.of();
        assertThat(lottoNumbers.size()).isEqualTo(Number.MAX);
    }

    @Test
    public void 로또번호를_6개를_반환한다() {
        int peekCount = Lotto.LOTTO_SIZE;
        NumberGenerator lottoNumbers = NumberGenerator.of();
        List<Number> peek = lottoNumbers.peek(peekCount);
        assertThat(peek.size()).isEqualTo(peekCount);
    }
}