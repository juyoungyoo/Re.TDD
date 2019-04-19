package com.juyoung.tddlotto;


import com.juyoung.tddlotto.model.Lotto;
import com.juyoung.tddlotto.model.LottoMachine;
import com.juyoung.tddlotto.model.LottoTicket;
import com.juyoung.tddlotto.model.Prize;
import org.junit.Test;

public class LottoConsoleTest {

    @Test
    public void 당첨번호_생성() {
        LottoMachine lottoMachine = new LottoMachine();

        Lotto winLotto = Lotto.of();
        System.out.println ("===========당첨번호========");
        System.out.println (winLotto.toString ());

        LottoTicket lottoTicket = lottoMachine.buy ();
        for (Lotto lotto : lottoTicket.getLottos()) {
            Prize prize = lotto.match(winLotto);
            System.out.println (prize.toString ());
        }
    }
}
