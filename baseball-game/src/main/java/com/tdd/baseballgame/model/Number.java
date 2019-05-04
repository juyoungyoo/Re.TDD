package com.tdd.baseballgame.model;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Number {

    public static int MIN = 0;
    public static int MAX = 9;

    private int number;

    private Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number of(int number) {
        return new Number(number);
    }

    private void validateNumber(int number) {
        if (MIN > number || MAX < number) {
            throw new IllegalArgumentException(MIN + "~" + MAX + "사이의 숫자만 생성 가능합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
