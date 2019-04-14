package com.juyoung.tddlotto.model;

import java.util.Set;


// 로또 티켓 6개
public class Lotto {

    static int LOTTO_SIZE = 6;

    private Set<LottoNumber> numbers;

    public Lotto(Set<LottoNumber> numbers) {
        validateSize(numbers);
        this.numbers = numbers;
    }

    private void validateSize(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 숫자는 6개만 가능합니다.");
        }
    }

    public int size() {
        return numbers.size();
    }

    public Prize match(Lotto other) {
        Set<LottoNumber> otherNumbers = other.numbers;
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
