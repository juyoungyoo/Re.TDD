package com.juyoung.tddlotto.model.ball;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class NumberGenerator {

    private static List<LottoNumber> lottoNumbers = new ArrayList<>();

    static {
        for (int num = LottoNumber.MIN_LOTTO_NUMBER; num <= LottoNumber.MAX_LOTTO_NUMBER; num++) {
            lottoNumbers.add(LottoNumber.of(num));
        }
    }

    private NumberGenerator() {
        shuffle();
    }

    public static NumberGenerator of(){
        return new NumberGenerator();
    }

    private void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> peek(int count) {
        return lottoNumbers.stream().limit(count).collect(toList());
    }

    public int size() {
        return lottoNumbers.size();
    }
}
