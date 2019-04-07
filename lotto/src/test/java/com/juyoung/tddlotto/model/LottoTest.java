package com.juyoung.tddlotto.model;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class LottoTest {


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


    public List<LottoNumber> ofLottoNumbers(int... numbers){
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(toList());
    }

}
