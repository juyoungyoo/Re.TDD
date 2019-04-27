package com.juyoung.tddlotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    public static int LOTTO_PRICE = 1000;
    public NumberGenerator numberGenerator;

    public LottoTicket buy(Wallet wallet,
                           int count) {
        wallet.spend(getPayMoney(count));

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(createLotto());
        }
        return new LottoTicket(lottos);
    }

    private int getPayMoney(int count) {
        return count * LOTTO_PRICE;
    }

    private Lotto createLotto() {
        numberGenerator = NumberGenerator.init();
        List<Number> peek = numberGenerator.getNumbers(Lotto.LOTTO_SIZE);
        return Lotto.init(peek);
    }

    public WinningLotto createWinLotto() {
        numberGenerator = numberGenerator.init();
        List<Number> numbers = numberGenerator.getNumbers(6);
        Number bonus = numberGenerator.getBonusNumber();
        return new WinningLotto(numbers, bonus);
    }

    public LottoResult result(LottoTicket ticket,
                              WinningLotto winning) {
        return ticket.result(winning);
    }

}