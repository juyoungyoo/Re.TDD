package com.juyoung.tddlotto.model;


import java.util.ArrayList;
import java.util.List;

// 1~45개 중에서 뽑는다. number 6개를
public class LottoMachine {


    public static Lotto createLotto() {
        List<LottoNumber> result = new ArrayList<>();
        for (int i = 0; i < Lotto.LOTTO_SIZE; i++) {
            int randomNumber = (int) (Math.random() * LottoNumber.MAX_LOTTO_NUMBER) + 1;  // Random class : study
            LottoNumber lottoNumber = new LottoNumber(randomNumber);
            result.add(lottoNumber);
        }
        return new Lotto(result);
    }
}
