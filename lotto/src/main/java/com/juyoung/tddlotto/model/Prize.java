package com.juyoung.tddlotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST(6, 100_000),
    SECOND(5, 10_000),
    THIRD(4, 1_000),
    FOURTH(3, 100),
    FIFTH(2, 10),
    SIX(1, 0),
    NONE(0, 0);

    private int matchCount;
    private int money;

    Prize(int matchCount,
          int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize of(int matchCount) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }


    public String getRank(){
        return this.name();
    }

    public int getMoney() {
        return this.money;
    }

    @Override
    public String toString() {
        return "Prize{" +
                "rank=" + this.ordinal() +
                ", matchCount=" + matchCount +
                ", money=" + money +
                '}';
    }
}
