package com.juyoung.tddlotto.model.lotto;

import com.juyoung.tddlotto.model.Prize;
import com.juyoung.tddlotto.model.ball.LottoNumber;
import com.juyoung.tddlotto.model.ball.NumberGenerator;
import lombok.Getter;

import java.util.List;

@Getter
public class Lotto{

    public static int LOTTO_SIZE = 6;
    private List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.numbers = lottoNumbers;
    }

    public static Lotto of() {
        NumberGenerator numbers = NumberGenerator.of();
        return new Lotto(numbers.peek(6));
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개만 가능합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public int match(Lotto other) {
        List<LottoNumber> otherNumbers = other.numbers;
        int matchCount = (int) otherNumbers.stream().filter(number -> this.numbers.contains(number)).count();
        return matchCount;
    }

    public Prize result(LottoWinning winning) {
        int match = winning.match(this);
        boolean bonus = winning.isExistBonus(this.getNumbers());
        return Prize.of(match, bonus);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }

}
