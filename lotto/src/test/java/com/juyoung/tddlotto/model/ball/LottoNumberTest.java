package com.juyoung.tddlotto.model.ball;

import org.junit.Test;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_45초과일때_실패한다() {
        LottoNumber.of(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_1미만일경우_실패한다() {
        LottoNumber.of(0);

    }
}