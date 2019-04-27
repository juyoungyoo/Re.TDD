package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberGeneratorTest {

    @Test
    public void 로또번호_45개를_생성한다() {
        NumberGenerator lottoNumbers = NumberGenerator.init();
        assertThat(lottoNumbers.size()).isEqualTo(Number.MAX);
    }

    @Test
    public void 로또번호를_6개를_반환한다() {
        int peekCount = Lotto.LOTTO_SIZE;
        NumberGenerator lottoNumbers = NumberGenerator.init();
        List<Number> peek = lottoNumbers.getNumbers(peekCount);
        assertThat(peek.size()).isEqualTo(peekCount);
    }

    @Test
    public void 로또번호6개는_보너스와_중복되지_않는다() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Number> numbers = numberGenerator.getNumbers(6);
        Number notMatch = numberGenerator.getBonusNumber();

        assertThat(numbers).doesNotContain(notMatch);
    }
}