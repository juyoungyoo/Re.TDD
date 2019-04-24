package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class WinningLotto extends Lotto{

    private static NumberGenerator numbersGenerator;
    private LottoNumber bonus;

    public WinningLotto(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        super(lottoNumbers);
        this.bonus = bonus;
    }

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
        this.bonus = numbersGenerator.peek(1).get(0);
    }

    public static WinningLotto of(){
        numbersGenerator = NumberGenerator.of();
        return new WinningLotto(numbersGenerator.peek(6));
    }

    @Override
    public int match(Lotto lotto) {
        int matchCount = super.match(lotto);
        if(isExistBonus(lotto.getNumbers())){
            matchCount++;
        }
        return matchCount;
    }

    public boolean isExistBonus(List<LottoNumber> numbers){
         if(numbers.contains(bonus)){
            return true;
         }
         return false;
    }

    @Override
    public List<LottoNumber> getNumbers() {
        List<LottoNumber> list = new ArrayList<>();
        list.addAll(super.getNumbers());
        return list;
    }

    @Override
    public int size() {
        if(Objects.nonNull(bonus)){
            return super.size() + 1;
        }
        return super.size();
    }
}
