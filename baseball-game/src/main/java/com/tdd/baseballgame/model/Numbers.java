package com.tdd.baseballgame.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Numbers {

    private static final int SIZE = 3;
    private List<Number> numbers;

    private Numbers(List<Number> numbers) {
        duplicateNumbers(numbers);
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    public static Numbers of(int... numbers) {
        List<Number> distinctNumbers = setDistinctNumbers(numbers);
        return new Numbers(distinctNumbers);
    }

    private static List<Number> setDistinctNumbers(int[] numbers) {
        return IntStream.of(numbers).distinct().mapToObj(Number::of).collect(Collectors.toList());
    }

    private void validateNumbers(List<Number> numbers) {
        if (SIZE != numbers.size()) {
            throw new IllegalArgumentException("숫자는 " + SIZE + "개만 생성가능합니다.");
        }
    }

    private void duplicateNumbers(List<Number> numbers) {
        if (SIZE > numbers.size()) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다");
        }
    }

    public int size() {
        return numbers.size();
    }

    public boolean contain(Number number) {
        return numbers.contains(number);
    }

    public boolean match(int location, Number number) {
        return numbers.get(location).equals(number);
    }


//    public NumbersResult result(Numbers numbers) {
//        NumbersResult resultTypes = new NumbersResult();
//        for (int i = 0; i < numbers.size(); i++) {
//            Number number = numbers.getNumbers().get(i);
//            resultTypes.add(ResultType.of(contain(number), match(i, number)));
//        }
//        return resultTypes;
//    }
}
