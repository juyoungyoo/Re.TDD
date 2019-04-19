package com.juyoung.tddlotto.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또는_6개의_로또넘버를_생성한다() {
        Lotto lotto = new Lotto();
        assertThat (lotto.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_7개_이상일때_실패한다() {
        ofLotto (1, 2, 3, 4, 5, 6, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_6개_미만일때_실패한다() {
        ofLotto (1, 2, 3, 4, 5);
    }


    @Test
    public void 로또번호_모두_일치() {
        Lotto lotto = ofLotto (1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto (1, 2, 3, 4, 5, 6);

        Prize result = lotto.match (other);

        assertThat (result).isEqualTo (Prize.FIRST);
    }

    @Test
    public void 로또번호_4개_일치() {
        Lotto lotto = ofLotto (1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto (1, 2, 3, 4, 7, 9);

        Prize result = lotto.match (other);

        assertThat (result).isEqualTo (Prize.THIRD);
    }

    protected static Lotto ofLotto(int... lottoNumbers) {
        List<LottoNumber> numbers = ofLottoNumbers (lottoNumbers);
        return new Lotto (numbers);
    }

    private static List<LottoNumber> ofLottoNumbers(int... numbers) {
        return Arrays.stream (numbers).mapToObj (LottoNumber::new).collect (Collectors.toList ());
    }
}
