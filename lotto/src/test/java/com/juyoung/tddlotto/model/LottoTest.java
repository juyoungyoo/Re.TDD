package com.juyoung.tddlotto.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static LottoNumber apply(int e) {
        LottoNumber number = new LottoNumber();
        return number.createNumber(e);
    }

    @Test
    public void 로또는_6개의_숫자를_가진다() {
//        List<Integer> numbers = IntStream.rangeClosed(1,6).boxed().collect(Collectors.toList());
//        Lotto lotto = new Lotto(numbers);
//        assertThat(lotto.size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또개수가_6개가_아닌경우_실패한다() {
        List<LottoNumber> lottoNumbers = ofLottoNumbers(1, 2, 3, 4, 5, 6, 7);
        new Lotto(lottoNumbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또는_중복이면_안된다() {
        List<LottoNumber> lottoNumbers = ofLottoNumbers(1, 2, 3, 4, 4, 6);
        new Lotto(lottoNumbers);
    }

    @Test
    public void 로또번호_모두_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto(1, 2, 3, 4, 5, 6);
        int result = lotto.match(other);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 로또번호_4개_일치() {
        Lotto lotto = ofLotto(1, 2, 3, 4, 5, 6);
        Lotto other = ofLotto(1, 2, 3, 4, 7, 9);
        int result = lotto.match(other);
        assertThat(result).isEqualTo(4);
    }

    // todo : match 수정 필요

    protected static Lotto ofLotto(int... lottoNumbers) {
        List<LottoNumber> numbers = ofLottoNumbers(lottoNumbers);
        return new Lotto(numbers);
    }

    public static List<LottoNumber> ofLottoNumbers(int... numbers){
        return Arrays.stream(numbers).mapToObj(LottoTest::apply).collect(toList());
    }

}
