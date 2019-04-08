package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoMachineTest {

    @Test
    public void 랜덤한_6개의_숫자를_생성한다() {
        int expected = 6;
        LottoMachine lottoMachine = new LottoMachine();
        Lotto lotto = lottoMachine.createLotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto.size()).isEqualTo(expected);
    }

    @Test
    public void 랜덤한_숫자를_중복_안되게_생성한다() {
        int countNumbers = 6;

        LottoMachine lottoMachine = new LottoMachine();
        Lotto result = lottoMachine.createUniqueRandomLotto();

        assertThat(result.size()).isEqualTo(countNumbers);
    }

    @Test
    public void 로또티켓을_n개_생성한다() {
        int n = 5;
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.createLottoByCount(n);
        assertThat(lottos).size().isEqualTo(n);
    }
}