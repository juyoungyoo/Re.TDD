package com.juyoung.tddlotto.model;

import org.junit.Test;

public class NumberTest{

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_45초과일때_실패한다(){
        Number.of(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_1미만일경우_실패한다(){ Number.of(0); }
}