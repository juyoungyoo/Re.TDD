package com.tdd.baseballgame.model.result;


import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class BaseballGameSummary {

    private Map<ResultType, Integer> summaryMap;

    public BaseballGameSummary(List<AnswerResult> answerResults) {
        summaryMap = Arrays.stream(ResultType.values())
                .collect(
                        Collectors.toMap(
                                resultType -> resultType,
                                resultType -> answerResults.stream()
                                        .mapToInt(e -> e.getCountResultType(resultType))
                                        .sum()
                        )
                );
    }

    public double getPercent(ResultType resultType) {
        double result = getCount(resultType);
        if(result == 0) {
            return 0;
        }
        return (result / getTotalCount() * 100);
    }

    public int getCount(ResultType resultType) {
        return summaryMap.getOrDefault(resultType,0);
    }

    private int getTotalCount() {
        return summaryMap.values().stream().mapToInt(e -> e).sum();
    }
}
