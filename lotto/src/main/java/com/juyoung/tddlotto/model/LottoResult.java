package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LottoResult {

    private Map<Prize, Integer> resultCount = new HashMap<>();

    public void countPlusOne(Prize prize) {
        if (prize == Prize.NONE) return;

        if (resultCount.containsKey(prize)) {
            resultCount.put(prize, resultCount.get(prize) + 1);
        }
        if (!resultCount.containsKey(prize)) {
            resultCount.put(prize, 1);
        }
    }

    public int getCount() {
        return resultCount.entrySet().stream()
                .filter(x -> x.getKey() != Prize.NONE)
                .mapToInt(x -> x.getValue()).sum();
    }

    public int getSummary() {
        int sum = 0;
        for (Map.Entry<Prize, Integer> result : resultCount.entrySet()) {
            sum += result.getKey().getMoney();
        }
        return sum;
    }
}