package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 당첨번호와_일치하는_번호갯수에_따른_결과확인() {
        assertThat(Prize.of(6)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(5)).isEqualTo(Prize.SECOND);
        assertThat(Prize.of(4)).isEqualTo(Prize.THIRD);
        assertThat(Prize.of(3)).isEqualTo(Prize.FOURTH);
        assertThat(Prize.of(2)).isEqualTo(Prize.FIFTH);
        assertThat(Prize.of(1)).isEqualTo(Prize.SIX);
        assertThat(Prize.of(0)).isEqualTo(Prize.NONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_매칭하는_개수가_음수일경우() {
        Prize.of(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_전체_사이즈보다_매칭번호_개수가_큰_경우() {
        Prize.of(7);
    }
}