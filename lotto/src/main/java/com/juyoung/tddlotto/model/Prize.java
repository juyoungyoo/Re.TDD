package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.Arrays;

import static com.juyoung.tddlotto.model.Lotto.LOTTO_SIZE;

@Getter
public enum Prize {

    FIRST(6, 150_000),
    SECOND(5, 100_000),
    THIRD(5, 50_000),
    FOURTH(4, 10_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    private int matchCount;
    private int money;

    Prize(int matchCount,
          int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Prize of(int matchCount,
                           boolean existBonus) {
        validateCount(matchCount);
        if (isPrizeOfSecond(matchCount, existBonus)) {
            return SECOND;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> isMatchCount(matchCount, prize))
                .findFirst()
                .orElse(Prize.NONE);
    }

    private static boolean isPrizeOfSecond(int matchCount, boolean existBonus) {
        if (matchCount == SECOND.getMatchCount() && existBonus) {
            return true;
        }
        return false;
    }

    private static boolean isMatchCount(int matchCount, Prize prize) {
        if (SECOND == prize) {
            return false;
        }
        return prize.matchCount == matchCount;
    }

    private static void validateCount(int matchCount) {
        if (0 > matchCount || LOTTO_SIZE < matchCount) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return this.name() + ", " + money + "원";
    }
}
