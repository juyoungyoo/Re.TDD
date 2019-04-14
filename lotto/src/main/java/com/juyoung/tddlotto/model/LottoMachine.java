package com.juyoung.tddlotto.model;

import java.util.*;

public class LottoMachine {

    private Random random;

    public LottoMachine() {
        this.random = new Random();
    }

    public Lotto createDirectLotto(int... numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (int number : numbers) {
            LottoNumber lottoNumber = createLottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        return this.createLotto(lottoNumbers);
    }

    public List<Lotto> createLottoByCount(int cnt) {
        List<Lotto> lottos = new ArrayList<>();
        while (cnt > lottos.size()) {
           lottos.add(this.createUniqueRandomLotto());
        }
        return lottos;
    }

    public Lotto createUniqueRandomLotto() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (Lotto.LOTTO_SIZE > lottoNumbers.size()) {
            lottoNumbers.add(this.createRandomNumber());
        }
        return createLotto(lottoNumbers);
    }

    private Lotto createLotto(Set<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private LottoNumber createRandomNumber() {
        return createLottoNumber(this.random.nextInt(LottoNumber.MAX_LOTTO_NUMBER) + 1);
    }

    private LottoNumber createLottoNumber(int i) {
        return LottoNumber.of(i);
    }


}
