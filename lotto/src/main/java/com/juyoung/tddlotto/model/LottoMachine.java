package com.juyoung.tddlotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static int LOTTO_PRICE = 1000;

    public LottoTicket buy(Wallet wallet,
                           int count) {
        wallet.spend(getPayMoney(count));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(NumberGenerator.getLotto());
        }
        return new LottoTicket(lottos);
    }

    private int getPayMoney(int count) {
        return count * LOTTO_PRICE;
    }
    public WinningLotto createWinLotto() {
        return NumberGenerator.getWinningLotto();
    }

    public LottoResult result(LottoTicket ticket,
                              WinningLotto winning) {
        return ticket.result(winning);
    }

}