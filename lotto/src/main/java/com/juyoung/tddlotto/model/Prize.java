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
                           boolean isExistBonus) {
        validateCount(matchCount);
        if (Prize.THIRD.matchCount == matchCount && isExistBonus) {
            return Prize.THIRD;
        }
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.matchCount == matchCount)
                .findFirst()
                .orElse(Prize.NONE);
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
