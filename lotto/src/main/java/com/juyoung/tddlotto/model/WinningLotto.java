package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.List;

@Getter
public class WinningLotto {

    private Lotto lotto;
    private Number bonus;

    public WinningLotto(Lotto lotto,
                        Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public WinningLotto(List<Number> numbers,
                        Number bonus) {
        this.lotto = new Lotto(numbers);
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
