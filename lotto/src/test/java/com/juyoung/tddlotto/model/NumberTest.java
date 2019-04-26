package com.juyoung.tddlotto.model;

import org.junit.Test;

public class NumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_최대값초과일때_실패한다() {
        Number.of(Number.MAX+1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_최소값미만일경우_실패한다() {
        Number.of(Number.MIN-1);
    }
}