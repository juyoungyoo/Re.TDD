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
        // todo : putIfAbsent 적용해보자
        resultCount.putIfAbsent(prize, 0);
        int prizeValue = resultCount.getOrDefault(prize, 0);
        resultCount.put(prize, prizeValue + 1);

        // todo : computeIfPresent 적용해보기
    }

    public int getCount() {
        return resultCount.entrySet().stream()
                .filter(x -> x.getKey() != Prize.NONE)
                .mapToInt(x -> x.getValue())
                .sum();
    }
    //ToDO
    public int getSummary() {
        int sum = 0;
        for (Map.Entry<Prize, Integer> result : resultCount.entrySet()) {
            sum += (result.getKey().getMoney() * result.getValue());
        }
        return sum;
    }
}