package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
public class NumberGenerator{

    private static List<Number> numbers = new ArrayList<>();

    static{
        for (int num = Number.MIN_LOTTO_NUMBER; num <= Number.MAX_LOTTO_NUMBER; num++) {
            numbers.add(Number.of(num));
        }
    }

    private NumberGenerator(){
        shuffle();
    }

    public static NumberGenerator of(){
        return new NumberGenerator();
    }

    private void shuffle(){
        Collections.shuffle(numbers);
    }

    public List<Number> peek(int count){
        return numbers.stream().limit(count).collect(toList());
    }

    public Number peek(){
        return numbers.get(0);
    }

    public int size(){
        return numbers.size();
    }
}
