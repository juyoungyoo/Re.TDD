package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;

@Getter
public class Lotto {

    public static int LOTTO_SIZE = 6;
    private List<Number> numbers;

    protected Lotto(List<Number> numbers) {
        validateSize(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public static Lotto init(List<Number> numbers) {
        return new Lotto(numbers);
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개만 가능합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public int match(Lotto other) {
        List<Number> otherNumbers = other.numbers;
        int matchCount = (int) otherNumbers.stream().filter(number -> this.numbers.contains(number)).count();
        return matchCount;
    }

    @Override
    public String toString() {
        return "Lotto " + numbers + " ";
    }
}
