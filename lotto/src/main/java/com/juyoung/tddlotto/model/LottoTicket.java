package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoTicket {

    private List<Lotto> lottos;

    public LottoTicket(int count) {
        lottos = new ArrayList<>();
        create(count);
    }

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private List<Lotto> create(int count) {
        do {
            lottos.add(Lotto.init());
        } while (lottos.size() < count);
        return lottos;
    }

    public LottoResult result(WinningLotto winning) {
        LottoResult lottoResult = LottoResult.of();
        for (Lotto lotto : this.lottos) {
            Prize result = winning.result(lotto);
            lottoResult.countPlusOne(result);
        }
        return lottoResult;
    }
}
