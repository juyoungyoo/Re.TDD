package com.juyoung.tddlotto.model;



public class LottoNumber {

    static int MIN_LOTTO_NUMBER = 1;
    static int MAX_LOTTO_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        this.validateNumber(number);
        this.number = number;
    }

    public void validateNumber(int number) {
        if(number < MIN_LOTTO_NUMBER|| number > MAX_LOTTO_NUMBER){
            throw new IllegalArgumentException();
        }
    }

}
