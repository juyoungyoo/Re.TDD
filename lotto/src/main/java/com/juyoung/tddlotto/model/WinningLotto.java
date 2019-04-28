package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.List;

@Getter
public class WinningLotto {

    public static final int BONUS_INDEX = 6;
    private Lotto lotto;
    private Number bonus;

    public WinningLotto(Lotto lotto,
                        Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public Prize result(Lotto lotto) {
        int match = this.lotto.match(lotto);
        boolean bonus = containsBonus(lotto.getNumbers());
        return Prize.of(match, bonus);
    }

    public boolean containsBonus(List<Number> numbers) {
        return numbers.contains(bonus);
    }
}
