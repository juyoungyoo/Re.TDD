package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class LottoResult{

    private Map<Prize, Integer> resultCount;

    private LottoResult(){
        this.resultCount = new HashMap<>();
    }

    public static LottoResult of(){
        return new LottoResult();
    }

    public void countPlusOne(Prize prize){
        int prizeValue = getCountByPrize(prize);
        resultCount.put(prize, prizeValue + 1);
    }

    private int getCountByPrize(Prize prize){
        return resultCount.getOrDefault(prize, 0);
    }

    public int getCount(){
        return resultCount.entrySet().stream()
                .filter(x -> x.getKey() != Prize.NONE)
                .mapToInt(x -> x.getValue()).sum();
    }

    public int getSummary(){
        int sum = 0;
        for (Map.Entry<Prize, Integer> result : resultCount.entrySet()) {
            sum += (result.getKey().getMoney() * result.getValue());
        }
        return sum;
    }
}