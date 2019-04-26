package com.juyoung.tddlotto.model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WalletTest {

    @Test
    public void 로또구매() {
        Wallet wallet = Wallet.of(10000);
        int spendMoney = 2000;
        wallet.spend(spendMoney);
        assertThat(wallet.getBalance()).isEqualTo(8000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액부족() {
        Wallet wallet = Wallet.of(1000);
        int spendMoney = 2000;
        wallet.spend(spendMoney);
    }

    @Test
    public void 상금수령() {
        Wallet wallet = Wallet.of(0);
        LottoResult lottoResult = LottoResult.of();
        List<Prize> prizes = Arrays.asList(Prize.FOURTH, Prize.FIFTH);
        for (Prize prize : prizes) {
            lottoResult.countPlusOne(prize);
        }

        wallet.incomePrice(lottoResult);
        assertThat(wallet.getBalance()).isEqualTo(15000);
    }
}
