package com.tdd.baseballgame.model;

import com.tdd.baseballgame.model.result.AnswerResult;
import lombok.Getter;

import java.util.Arrays;

@Getter
public class Answer {

    private Numbers numbers;

    private Answer(Numbers numbers) {
        this.numbers = numbers;
    }

    public static Answer of(String input){
        String[] inputStr = split(input);
        Numbers numbers = convertNumbers(inputStr);
        return new Answer(numbers);
    }

    private static String[] split(String input) {
        if(!input.contains(",")){
            throw new IllegalArgumentException("숫자를 ,로 구분하여 입력해주세요. ex)1,2,3");
        }
        return input.split(",");
    }

    private static Numbers convertNumbers(String[] inputStr) {
        return Numbers.of(Arrays.stream(inputStr).mapToInt(Integer::new).toArray());
    }

    public AnswerResult ask(Numbers numbers) {
        return new AnswerResult(this.numbers.result(numbers));
    }
}
