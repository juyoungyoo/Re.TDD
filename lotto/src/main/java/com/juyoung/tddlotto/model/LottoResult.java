package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LottoResult {

    private Map<Prize, Integer> resultCount;

    public LottoResult() {
        this.resultCount = new HashMap<>();
    }

    public void countPlusOne(Prize prize) {
        resultCount.putIfAbsent(prize, 0);
        resultCount.computeIfPresent(prize, (key, value) -> ++value); // TODO : 증감 연산자 순서 영향받음
    }

    public int getCount() {
        return resultCount.entrySet().stream()
                .filter(x -> x.getKey() != Prize.NONE)
                .mapToInt(x -> x.getValue())
                .sum();
    }

    public int getSummary() {
        int sum = 0;
        for (Map.Entry<Prize, Integer> result : resultCount.entrySet()) {
            sum += resultCount.compute(result.getKey(), (key, value) -> key.getMoney() * value);
        }
        return sum;
    }
}