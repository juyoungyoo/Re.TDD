package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    public void 로또번호_45개를_생성한다() {
        NumberGenerator lottoNumbers = NumberGenerator.init();
        assertThat(lottoNumbers.size()).isEqualTo(Number.MAX);
    }
}