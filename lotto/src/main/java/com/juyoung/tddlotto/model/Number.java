package com.juyoung.tddlotto.model;

import java.util.Objects;

public class Number implements Comparable<Number>{

    static int MIN_LOTTO_NUMBER = 1;
    static int MAX_LOTTO_NUMBER = 45;

    private int number;

    private Number(int number){
        validateNumber(number);
        this.number = number;
    }

    public static Number of(int number){
        return new Number(number);
    }

    private void validateNumber(int number){
        if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MIN_LOTTO_NUMBER + " ~ " + MAX_LOTTO_NUMBER + "숫자만 가능합니다");
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode(){
        return Objects.hash(number);
    }

    @Override
    public String toString(){
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Number o){
        if (number < o.number) {
            return -1;
        } else if (number == o.number) {

            return 0;
        } else {
            return 1;
        }
    }
}
