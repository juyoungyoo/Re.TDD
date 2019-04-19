package com.juyoung.tddlotto.model;

import java.util.List;

public class Lotto {

    static int LOTTO_SIZE = 6;
    private List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(){
        LottoNumbers lottoNumbers = LottoNumbers.of();
        lottoNumbers.shuffle();
        List<LottoNumber> list = lottoNumbers.peek(LOTTO_SIZE);
        return new Lotto(list);
    }

    private void validateSize(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개만 가능합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public Prize match(Lotto other) {
        List<LottoNumber> otherNumbers = other.numbers;
        int matchCount = (int) otherNumbers.stream().filter(number -> this.numbers.contains(number)).count();
        return Prize.of(matchCount);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
