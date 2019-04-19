package com.juyoung.tddlotto.model;

import java.util.Arrays;

public enum Prize {

    FIRST (6, 1_000_000),
    SECOND (5, 500_000),
    THIRD (4, 200_000),
    FOURTH (3, 50_000),
    FIFTH (2, 5_000),
    SIX (1, 0),
    NONE (0, 0);

    private int matchCount;
    private int money;

    Prize(int matchCount,
          int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize of(int matchCount) {
        return Arrays.stream (Prize.values ())
                .filter (prize -> prize.matchCount == matchCount)
                .findFirst ()
                .orElseThrow (IllegalArgumentException::new);
    }

    @Override
    public String toString() {
        return "Prize{" +
                "rank=" + this.name () +
                ", matchCount=" + matchCount +
                ", money=" + money +
                '}';
    }
}
