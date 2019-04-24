package com.juyoung.tddlotto;

import com.juyoung.tddlotto.io.InputConsole;
import com.juyoung.tddlotto.io.OutputConsole;
import com.juyoung.tddlotto.model.LottoMachine;
import com.juyoung.tddlotto.model.LottoResult;
import com.juyoung.tddlotto.model.LottoTicket;
import com.juyoung.tddlotto.model.WinningLotto;

public class Main {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        int buy = InputConsole.buyTicket();
        System.out.println(":::: 로또 " + buy + "개 구매");

        LottoTicket ticket = lottoMachine.buy(buy);
        OutputConsole.buyTicket(ticket);

        WinningLotto winningLotto = lottoMachine.createWinLotto();
        OutputConsole.winningLotto(winningLotto);

        System.out.println();
        System.out.println();

        LottoResult result = lottoMachine.result(ticket, winningLotto);
        OutputConsole.result(result);
    }
}
