package com.juyoung.tddlotto.model.lotto;

import com.juyoung.tddlotto.model.ball.LottoNumber;
import com.juyoung.tddlotto.model.ball.NumberGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
public class LottoWinning extends Lotto{

    private static NumberGenerator numbersGenerator;
    private LottoNumber bonus;

    public LottoWinning(List<LottoNumber> lottoNumbers, LottoNumber bonus) {
        super(lottoNumbers);
        this.bonus = bonus;
    }

    public LottoWinning(List<LottoNumber> lottoNumbers) {
        super(lottoNumbers);
        this.bonus = numbersGenerator.peek(1).get(0);
    }

    public static LottoWinning of(){
        numbersGenerator = NumberGenerator.of();
        return new LottoWinning(numbersGenerator.peek(6));
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
