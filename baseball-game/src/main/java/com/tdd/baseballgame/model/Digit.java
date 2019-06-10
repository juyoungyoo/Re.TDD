package com.tdd.baseballgame.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Digit {

    public static int MIN = 0;
    public static int MAX = 9;

    private int number;

    private Digit(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (MIN > number || MAX < number) {
            throw new IllegalArgumentException(MIN + "~" + MAX + "사이의 숫자만 생성 가능합니다.");
        }
    }

    public static Digit of(int number) {
        return new Digit(number);
    }
}
