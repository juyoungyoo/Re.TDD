package com.juyoung.tddlotto.model;

public class LottoMachine {

    public static int LOTTO_PRICE = 1000;

    public LottoTicket buy(Wallet wallet,
                           int count) {
        wallet.spend(getPayMoney(count));
        return new LottoTicket(count);
    }

    private int getPayMoney(int count) {
        return count * LOTTO_PRICE;
    }

    public WinningLotto createWinLotto() {
        return WinningLotto.init();
    }

    public LottoResult result(LottoTicket ticket,
                              WinningLotto winning) {
        return ticket.result(winning);
    }

}