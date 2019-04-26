package com.juyoung.tddlotto.model;

import static com.juyoung.tddlotto.model.LottoTicket.BUY_LOTTO_COUNT;

public class LottoMachine {

    public static int LOTTO_PRICE = 1000;

    public LottoTicket buy(Wallet wallet) {
        wallet.spend(getPayMoney(0));
        return LottoTicket.of();
    }

    public LottoTicket buy(Wallet wallet,
                           int count) {
        wallet.spend(getPayMoney(count));
        return LottoTicket.of(count);
    }

    private int getPayMoney(int count) {
        if (count > 0) {
            return count * LOTTO_PRICE;
        }
        return BUY_LOTTO_COUNT * LOTTO_PRICE;
    }

    public WinningLotto createWinLotto() {
        return WinningLotto.of();
    }

    public LottoResult result(LottoTicket ticket,
                              WinningLotto winning) {
        return ticket.result(winning);
    }

}