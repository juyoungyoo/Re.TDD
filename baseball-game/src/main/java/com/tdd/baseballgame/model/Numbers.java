package com.tdd.baseballgame.model;

import com.tdd.baseballgame.model.result.NumbersResult;
import com.tdd.baseballgame.model.result.ResultType;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Getter
public class Numbers {

    public static final int SIZE = 3;
    private List<Digit> digits;

    private Numbers(List<Digit> digits) {
        duplicateNumbers(digits);
        validateNumbers(digits);
        this.digits = digits;
    }

    public static Numbers of(int... numbers) {
        List<Digit> distinctDigits = setDistinctNumbers(numbers);
        return new Numbers(distinctDigits);
    }


    private static List<Digit> setDistinctNumbers(int[] numbers) {
        return IntStream.of(numbers).distinct().mapToObj(Digit::of).collect(Collectors.toList());
    }

    private void validateNumbers(List<Digit> digits) {
        if (SIZE != digits.size()) {
            throw new IllegalArgumentException("숫자는 " + SIZE + "개만 생성가능합니다.");
        }
    }

    private void duplicateNumbers(List<Digit> digits) {
        if (SIZE > digits.size()) {
            throw new IllegalArgumentException("숫자는 중복될 수 없습니다");
        }
    }

    public int size() {
        return digits.size();
    }

    public boolean contain(Digit digit) {
        return digits.contains(digit);
    }

    public boolean match(int location, Digit digit) {
        return digits.get(location).equals(digit);
    }

    public NumbersResult result(Numbers numbers) {
        NumbersResult resultTypes = new NumbersResult();

        for (int i = 0; i < numbers.size(); i++) {
            Digit digit = numbers.getDigits().get(i);
            ResultType result = ResultType.of(contain(digit), match(i, digit));
            resultTypes.add(result);
        }
        return resultTypes;
    }
}
