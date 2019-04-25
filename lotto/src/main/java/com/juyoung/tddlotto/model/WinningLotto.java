package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class WinningLotto extends Lotto{

    private static NumberGenerator numbersGenerator;
    private Number bonus;

    public WinningLotto(List<Number> numbers, Number bonus) {
        super(numbers);
        this.bonus = bonus;
    }

    private WinningLotto(List<Number> numbers) {
        super(numbers);
        this.bonus = numbersGenerator.peek();
    }

    public static WinningLotto of(){
        numbersGenerator = NumberGenerator.of();
        return new WinningLotto(numbersGenerator.peek(6));
    }

    public Prize result(Lotto lotto) {
        int match = match(lotto);
        boolean bonus = isMatchBonus(lotto.getNumbers());
        return Prize.of(match, bonus);
    }

    @Override
    public int match(Lotto lotto) {
        int matchCount = super.match(lotto);
        if(isMatchBonus(lotto.getNumbers())){
            matchCount++;
        }
        return matchCount;
    }

    public boolean isMatchBonus(List<Number> numbers){
         if(numbers.contains(bonus)){
            return true;
         }
         return false;
    }

    @Override
    public int size() {
        if(Objects.nonNull(bonus)){
            return super.size() + 1;
        }
        return super.size();
    }
}
