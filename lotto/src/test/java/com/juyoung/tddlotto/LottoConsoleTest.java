package com.juyoung.tddlotto;


import com.juyoung.tddlotto.model.Lotto;
import com.juyoung.tddlotto.model.LottoMachine;
import com.juyoung.tddlotto.model.Prize;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

public class LottoConsoleTest {

    @Test
    public void 당첨번호_생성() {
        LottoMachine lottoMachine = new LottoMachine();
        Lotto winLotto = lottoMachine.createUniqueRandomLotto();
//        Lotto winLotto = lottoMachine.createDirectLotto(1, 2, 3, 4, 5, 6);
        System.out.println("=======당첨번호==========");
        System.out.println(winLotto.toString());
        Scanner scanner = new Scanner(System.in);
        System.out.println("============= 로또를 몇개 구매하시겠습니까? =============");
        int buy = 2;

        List<Lotto> buyLottos = lottoMachine.createLottoByCount(buy);
        System.out.println("============= 당첨 확인 =============");
        for (Lotto lotto : buyLottos) {
            System.out.println("======= lotto =====\n" + lotto.toString());
            Prize prize = lotto.match(winLotto);
            System.out.println(prize.toString());
        }

    }
}
