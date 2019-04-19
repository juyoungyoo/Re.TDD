package com.juyoung.tddlotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    private static int BUY_LOTTO_COUNT = 5;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoTicket() {
        create();
    }

    public static LottoTicket of(){
        return new LottoTicket();
    }

    private List<Lotto> create(){
        do {
            lottos.add(new Lotto());
        }while(lottos.size() < BUY_LOTTO_COUNT);
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
