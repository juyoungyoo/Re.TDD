package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    @Test
    public void 당첨번호와_일치하는_번호갯수에_따른_결과확인() {
        assertThat(prizeOf(6)).isEqualTo(Prize.FIRST);
        assertThat(prizeOf(5)).isEqualTo(Prize.SECOND);
        assertThat(prizeOf(5, true)).isEqualTo(Prize.THIRD);
        assertThat(prizeOf(4)).isEqualTo(Prize.FOURTH);
        assertThat(prizeOf(3)).isEqualTo(Prize.FIFTH);
        assertThat(prizeOf(2)).isEqualTo(Prize.NONE);
        assertThat(prizeOf(1)).isEqualTo(Prize.NONE);
        assertThat(prizeOf(0)).isEqualTo(Prize.NONE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_매칭하는_개수가_음수일경우() {
        prizeOf(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호_전체_사이즈보다_매칭번호_개수가_큰_경우() {
        prizeOf(7);
    }

    private Prize prizeOf(int matchCount) {
        return prizeOf(matchCount, false);
    }

    private Prize prizeOf(int matchCount,
                          boolean isExistBonus) {
        return Prize.of(matchCount, isExistBonus);
    }
}