package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class WinningLotto {

    private static NumberGenerator numbersGenerator;
    private Lotto lotto;
    private Number bonus;

    public WinningLotto(Lotto lotto, Number bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    private WinningLotto() {
        this.lotto = lotto.init();
        this.bonus = numbersGenerator.peek();
    }

    public static WinningLotto init() {
        numbersGenerator = numbersGenerator.of();
        return new WinningLotto();
    }

    public Prize result(Lotto lotto) {
        int match = this.lotto.match(lotto);
        boolean bonus = containsBonus(lotto.getNumbers());
        return Prize.of(match, bonus);
    }

    public boolean containsBonus(List<Number> numbers) {
        return numbers.contains(bonus);
    }

    public int size() {
        if (Objects.nonNull(bonus)) {
            return lotto.size() + 1;
        }
        return lotto.size();
    }
}
