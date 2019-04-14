package com.juyoung.tddlotto.model;

import java.util.HashMap;
import java.util.Objects;

public class LottoNumber {

    private static final HashMap<Integer, LottoNumber> existNumber = new HashMap<>();
    static int MIN_LOTTO_NUMBER = 1;
    static int MAX_LOTTO_NUMBER = 45;

    private int number;

    private LottoNumber(int number) {
        this.validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + "숫자만 가능합니다");
        }
    }

    // of, valueOf, from, withColumn
    public static LottoNumber of(int number) {
        if (!existNumber.containsKey(number)) {
            LottoNumber lottoNumber = new LottoNumber(number);
            existNumber.put(number, lottoNumber);
            return lottoNumber;
        } else {
            return existNumber.get(number);
        }
    }

    @Override
    public String toString() {
        return "LottoNumber{" +
                "number=" + number +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
