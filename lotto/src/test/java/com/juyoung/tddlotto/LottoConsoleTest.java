package com.juyoung.tddlotto;


import com.juyoung.tddlotto.model.LottoMachine;
import com.juyoung.tddlotto.model.Prize;
import com.juyoung.tddlotto.model.lotto.Lotto;
import com.juyoung.tddlotto.model.lotto.LottoTicket;
import com.juyoung.tddlotto.model.lotto.LottoWinning;
import org.junit.Test;

public class LottoConsoleTest {

    @Test
    public void 당첨번호_생성() {
        LottoMachine lottoMachine = new LottoMachine();

        LottoWinning winLotto = LottoWinning.of();

        System.out.println ("===========당첨번호========");
        System.out.println (winLotto.toString ());

        LottoTicket lottoTicket = lottoMachine.buy ();
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto);
            Prize prize = lotto.result(winLotto);
            System.out.println (prize.toString ());
        }
    }
}
