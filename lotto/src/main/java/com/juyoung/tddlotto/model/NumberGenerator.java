package com.juyoung.tddlotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class NumberGenerator {

    private static List<Number> numbers;

    static {
        numbers = IntStream.rangeClosed(Number.MIN, Number.MAX).mapToObj(Number::of).collect(Collectors.toList());
    }

    public static Lotto getLotto() {
        List<Number> numbers = getNumbers(Lotto.LOTTO_SIZE);
        return new Lotto(numbers);
    }

    private static List<Number> getNumbers(int count) {
        Collections.shuffle(numbers);
        return numbers.stream().limit(count).collect(toList());
    }

    public static WinningLotto getWinningLotto(){
        List<Number> numbers = getNumbers(7);
        Number bonusNumber = numbers.remove(WinningLotto.BONUS_INDEX);
        Lotto lotto = new Lotto(numbers);
        return new WinningLotto(lotto, bonusNumber);
    }
}
