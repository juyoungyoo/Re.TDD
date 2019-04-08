package com.juyoung.tddlotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoMachine {

    private Random random;

    public LottoMachine() {
        this.random = new Random();
    }

    public Lotto createDirectLotto(int... numbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int number : numbers) {
            LottoNumber lottoNumber = createLottoNumber(number);
            lottoNumbers.add(lottoNumber);
        }
        return this.createLotto(lottoNumbers);
    }

    public List<Lotto> createLottoByCount(int cnt) {
        List<Lotto> lottos = new ArrayList<>();
        while (cnt > lottos.size()) {
            try {
                lottos.add(this.createUniqueRandomLotto());
            } catch (Exception e) {}
        }
        return lottos;
    }

    public Lotto createUniqueRandomLotto() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        while (Lotto.LOTTO_SIZE > lottoNumbers.size()) {
            try {
                lottoNumbers.add(this.createRandomNumber());
            } catch (IllegalArgumentException e) {
            }
        }
        return createLotto(lottoNumbers);
    }

    private Lotto createLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private LottoNumber createRandomNumber() {
        return createLottoNumber(this.random.nextInt(LottoNumber.MAX_LOTTO_NUMBER) + 1);
    }

    private LottoNumber createLottoNumber(int i) {
        return LottoNumber.createNumber(i);
    }


}
