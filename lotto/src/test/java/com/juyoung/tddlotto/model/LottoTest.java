package com.juyoung.tddlotto.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 로또는_6개의_로또넘버를_생성한다() {
        Lotto lotto = Lotto.of();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_7개_이상일때_실패한다() {
        ofLotto(1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_6개_미만일때_실패한다() {
        ofLotto(1, 2, 3, 4, 5);
    }

    public static Lotto ofLotto(int... lottoNumbers) {
        List<Number> numbers = ofLottoNumbers(lottoNumbers);
        return new Lotto(numbers);
    }

    public static List<Number> ofLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(Number::of).collect(Collectors.toList());
    }
}