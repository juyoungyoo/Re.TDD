package com.juyoung.tddlotto.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static LottoNumber apply(int e) {
        return LottoNumber.of(e);
    }

    // First create test method
    @Test
    public void 로또는_6개의_숫자를_가진다() {
//        List<Integer> numbers = IntStream.rangeClosed(1,6).boxed().collect(Collectors.toList());
//        Lotto lotto = new Lotto(numbers);
//        assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또개수가_6개가_아닌경우_실패한다() {
        Set<LottoNumber> lottoNumbers = ofLottoNumbers(1, 2, 3, 4, 5, 6, 7);
        new Lotto(lottoNumbers);
    }

    @Test
    public void 로또번호_모두_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto(1, 2, 3, 4, 5, 6);

        Prize result = lotto.match(other);

        assertThat(result).isEqualTo(Prize.FIRST);
    }

    @Test
    public void 로또번호_4개_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto(1, 2, 3, 4, 7, 9);

        Prize result = lotto.match(other);

        assertThat(result).isEqualTo(Prize.THIRD);
    }

    protected static Lotto ofLotto(int... lottoNumbers) {
        Set<LottoNumber> numbers = ofLottoNumbers(lottoNumbers);
        return new Lotto(numbers);
    }

    public static Set<LottoNumber> ofLottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoTest::apply).collect(Collectors.toSet());
    }

}
