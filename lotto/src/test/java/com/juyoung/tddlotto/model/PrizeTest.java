package com.juyoung.tddlotto.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PrizeTest {

    // TODO 테스트 개선
    // TODO assert를 더 효율적으로 바꾸기
    @Test
    public void 번호가_6개_모두_일치할때_1등이다() {
        assertThat(Prize.of(6)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(5)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(4)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(3)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(2)).isEqualTo(Prize.FIRST);
        assertThat(Prize.of(1)).isEqualTo(Prize.FIRST);
        assertPrize(6, Prize.FIRST);
    }

    @Test
    public void 번호가_5개_일치할때_2등이다() {
        Prize expected = Prize.of(5);
        boolean result = expected.equals(Prize.SECOND);
        assertThat(result).isTrue();
    }

    private void assertPrize(int matchCount, Prize expected) {
        assertThat(Prize.of(matchCount)).isEqualTo(expected);
    }

    @Test
    public void 로또번호가_모두_불일치할때_6등이다() {
        Prize expected = Prize.of(0);
        boolean result = expected.equals(Prize.NONE);
        assertThat(result).isTrue();
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