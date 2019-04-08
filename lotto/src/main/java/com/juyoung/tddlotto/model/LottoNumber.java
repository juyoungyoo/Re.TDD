package com.juyoung.tddlotto.model;

import java.util.HashMap;

public class LottoNumber {

    static int MIN_LOTTO_NUMBER = 1;
    static int MAX_LOTTO_NUMBER = 45;

    private int number;
    private static HashMap<Integer,LottoNumber> existNumber = new HashMap<>();

    public LottoNumber(){}

    public LottoNumber(int number) {
        this.validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if(number < MIN_LOTTO_NUMBER|| number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException(MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + "숫자만 가능합니다");
        }
    }

    public LottoNumber createNumber(int number) {
        if (!existNumber.containsKey(number)) {
            existNumber.put(number, new LottoNumber(number));
        }
        return existNumber.get(number);
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }
}
