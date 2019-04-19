package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    public void 로또번호를_6개를_반환한다() {
        int peekCount = 6;
        LottoNumbers lottoNumbers = LottoNumbers.of();
        List<LottoNumber> peek = lottoNumbers.peek(peekCount);
        assertThat(peek).containsExactly(getLottoNumbers(1, 2, 3, 4, 5, 6));
        assertThat(peek.size()).isEqualTo(peekCount);
    }

    private LottoNumber[] getLottoNumbers(int... numbers){
        LottoNumber[] lottoNumbers = new LottoNumber[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            lottoNumbers[i] = getLottoNumber(numbers[i]);
        }
        return lottoNumbers;
    }

    private LottoNumber getLottoNumber(int number) {
        return LottoNumber.of(number);
    }
}