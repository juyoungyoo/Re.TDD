package com.juyoung.tddlotto.model;

import java.util.Objects;

public class Number implements Comparable<Number> {

    static int MIN = 1;
    static int MAX = 45;

    private int number;

    private Number(int number) {
        validateNumber(number);
        this.number = number;
    }

    public static Number of(int number) {
        return new Number(number);
    }

    private void validateNumber(int number) {
        if (number < MIN || number > MAX) {
            throw new IllegalArgumentException(MIN + " ~ " + MAX + "숫자만 가능합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    @Override
    public int compareTo(Number o) {
        return Integer.compare(number, o.number);
    }
}
