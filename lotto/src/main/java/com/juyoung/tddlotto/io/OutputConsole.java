package com.juyoung.tddlotto.io;

import com.juyoung.tddlotto.model.*;

import java.util.List;
import java.util.Map;

public class OutputConsole {
    public static void buyTicket(LottoTicket ticket) {
        System.out.println("=========구매한 티켓내역============");
        List<Lotto> lottos = ticket.getLottos();
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
        System.out.println("================================\n");
    }

    public static void winningLotto(WinningLotto winningLotto) {
        System.out.println("=============당첨번호=============");
        System.out.println(winningLotto.getNumbers() + " [" + winningLotto.getBonus() + "]");
        System.out.println("================================\n");
    }

    public static void result(LottoResult lottoResult) {
        System.out.println("********************************");
        System.out.println("=============결과확인=============");
        System.out.println("당첨된 총 갯수 : " + lottoResult.getCount() + "개");
        System.out.println("당첨된 총 금액 : " + lottoResult.getSummary() + "원");
        Map<Prize, Integer> resultCount = lottoResult.getResultCount();
        for (Map.Entry<Prize, Integer> result : resultCount.entrySet()){
            if(result.getKey() == Prize.NONE){
                continue;
            }
            System.out.println(result.getKey().name() + " : " + result.getValue() + "개");
        }
        System.out.println("********************************");
    }
}
