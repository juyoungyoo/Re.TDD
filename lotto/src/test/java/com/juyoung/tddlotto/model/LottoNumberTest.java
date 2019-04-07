package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @Test
    public void 로또_생성() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_45초과일때_실패한다() {
        new LottoNumber(46);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또숫자가_1미만일경우_실패한다() {
//        List<LottoNumber> lottoNumbers = ofLottoNumbers(1, 2, 3, 4, 5, 0);
//        new Lotto(lottoNumbers);
        new LottoNumber(0);
    }

    public List<LottoNumber> ofLottoNumbers(int... numbers){
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(toList());
    }
}