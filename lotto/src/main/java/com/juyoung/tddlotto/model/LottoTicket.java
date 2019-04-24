package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoTicket {

    private static int BUY_LOTTO_COUNT = 5;
    private List<Lotto> lottos = new ArrayList<>();

    private LottoTicket() {
        create();
    }

    public LottoTicket(List<Lotto> lottos){
        this.lottos = lottos;
    }

    public static LottoTicket of() {
        return new LottoTicket();
    }

    public static LottoTicket of(int buyCount) {
        BUY_LOTTO_COUNT = buyCount;
        return new LottoTicket();
    }

    private List<Lotto> create() {
        do {
            lottos.add(Lotto.of());
        } while (lottos.size() < BUY_LOTTO_COUNT);
        return lottos;
    }

    public LottoResult result(WinningLotto winning){
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto: this.lottos) {
            Prize result = lotto.result(winning);
            lottoResult.countPlusOne(result);
        }
       return lottoResult;
    }
}
