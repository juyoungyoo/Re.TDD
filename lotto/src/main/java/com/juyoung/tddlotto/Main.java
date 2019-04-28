package com.juyoung.tddlotto;

import com.juyoung.tddlotto.io.InputConsole;
import com.juyoung.tddlotto.io.OutputConsole;
import com.juyoung.tddlotto.model.*;

public class Main {

    public static void main(String[] args) {

        LottoMachine lottoMachine = new LottoMachine();
        int balance = InputConsole.inputBalance();
        Wallet wallet = Wallet.of(balance);

        while (true) {
            try {
                if (!wallet.isBalance()) {
                    System.out.println("로또를 구매할 수 없습니다.\n프로그램 종료합니다.");
                    break;
                }
                int buy = InputConsole.buyTicket();

                LottoTicket ticket = lottoMachine.buy(wallet, buy);
                System.out.println(":::: 로또 " + buy + "개 구매");
                OutputConsole.buyTicket(ticket);

                WinningLotto winningLotto = lottoMachine.createWinLotto();
                OutputConsole.winningLotto(winningLotto);

                LottoResult result = lottoMachine.result(ticket, winningLotto);
                OutputConsole.result(result);
                wallet.incomePrice(result);

                System.out.println("내 지갑 : " + wallet.getBalance() + "원");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
