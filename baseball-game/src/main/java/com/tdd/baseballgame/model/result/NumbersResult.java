package com.tdd.baseballgame.model.result;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
public class NumbersResult {

    private List<ResultType> resultTypes;

    public NumbersResult(List<ResultType> resultTypes) {
        this.resultTypes = resultTypes;
    }

    public NumbersResult() {
        resultTypes = new ArrayList<>();
    }

    public void add(ResultType result) {
        resultTypes.add(result);
    }

    public int matchCount(ResultType resultType) {
        return Math.toIntExact(resultTypes.stream()
                .filter(type -> type.equals(resultType))
                .count());
    }
}