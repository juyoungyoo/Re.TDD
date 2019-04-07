package com.juyoung.tddlotto.model;

import java.util.List;

public class Lotto {

    static int LOTTO_SIZE = 6;

    List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validateDuplication(numbers);
        validateSize(numbers);

        this.numbers = numbers;
    }

    private void validateDuplication(List<LottoNumber> numbers) {
        if(numbers.stream().distinct().count() != numbers.size()){
            throw new IllegalArgumentException("로또 숫자가 중복되었습니다.");
        }
    }

    private void validateSize(List<LottoNumber> numbers) {
        if(numbers.size() !=  LOTTO_SIZE){
            throw new IllegalArgumentException("로또 숫자는 6개만 가능합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public List<LottoNumber> getNumbers() {
        return this.numbers;
    }

}
