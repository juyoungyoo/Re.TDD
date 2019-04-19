package com.juyoung.tddlotto.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class LottoTicket {

    private static int BUY_LOTTO_COUNT = 5;
    private List<Lotto> lottos = new ArrayList<> ();

    private LottoTicket() {
        create ();
    }

    public static LottoTicket of() {
        return new LottoTicket ();
    }

    private List<Lotto> create() {
        do {
            lottos.add (Lotto.of ());
        } while (lottos.size () < BUY_LOTTO_COUNT);
        return lottos;
    }
}
