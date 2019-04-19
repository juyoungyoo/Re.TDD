package com.juyoung.tddlotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final ArrayList<LottoNumber> lottoNumbers = new ArrayList<>();

    public static LottoNumbers of() {
        for (int num = LottoNumber.MIN_LOTTO_NUMBER; num <= LottoNumber.MAX_LOTTO_NUMBER; num++) {
            lottoNumbers.add(new LottoNumber(num));
        }
        return new LottoNumbers();
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> peek(int count) {
        return lottoNumbers.stream().limit(count).collect(Collectors.toList());
    }
}
