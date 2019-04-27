package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Getter
public class NumberGenerator {

    private static List<Number> numbers;

    static {
        numbers = IntStream.rangeClosed(Number.MIN, Number.MAX).mapToObj(Number::of).collect(Collectors.toList());
    }

    public static NumberGenerator init() {
        Collections.shuffle(numbers);
        return new NumberGenerator();
    }

    public List<Number> getNumbers(int count) {
        return numbers.stream().limit(count).collect(toList());
    }

    public Number getBonusNumber() {
        return numbers.get(Lotto.LOTTO_SIZE);
    }

    public int size() {
        return numbers.size();
    }
}
