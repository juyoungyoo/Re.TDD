package com.juyoung.tddlotto.model;

public class LottoMachine {

    public LottoTicket buy() {
        return LottoTicket.of();
    }

    public LottoTicket buy(int count) {
        return LottoTicket.of(count);
    }

    public WinningLotto createWinLotto(){
        return WinningLotto.of();
    }

    public LottoResult result(LottoTicket ticket, WinningLotto winning){
        return ticket.result(winning);
    }

}