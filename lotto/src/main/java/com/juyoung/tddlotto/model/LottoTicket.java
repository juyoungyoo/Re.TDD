package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.List;

@Getter
public class LottoTicket {

    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResult result(WinningLotto winning) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : this.lottos) {
            Prize result = winning.result(lotto);
            lottoResult.countPlusOne(result);
        }
        return lottoResult;
    }
}
