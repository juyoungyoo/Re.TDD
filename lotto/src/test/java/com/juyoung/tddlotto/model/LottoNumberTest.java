package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    // todo : question
    @Test
    public void 로또번호를_생성한다() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.createNumber(1);
        assertThat(lottoNumber.createNumber(1)).isEqualTo(lottoNumber.createNumber(1));
//        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_45초과일때_실패한다() {
        new LottoNumber(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_1미만일경우_실패한다() {
        new LottoNumber(0);
    }

}