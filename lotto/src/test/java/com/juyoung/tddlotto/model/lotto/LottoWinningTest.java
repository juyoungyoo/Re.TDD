package com.juyoung.tddlotto.model.lotto;

import com.juyoung.tddlotto.model.ball.LottoNumber;
import org.junit.Test;

import java.util.List;

import static com.juyoung.tddlotto.model.lotto.LottoTest.ofLotto;
import static com.juyoung.tddlotto.model.lotto.LottoTest.ofLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {

    @Test
    public void 당첨번호를_생성한다() {
        LottoWinning lottoWinning = LottoWinning.of();
        assertThat(lottoWinning.size()).isEqualTo(7);
        assertThat(lottoWinning.getBonus()).isNotNull();
    }

    @Test
    public void 당첨번호와_해당로또번호와_일치하는_갯수() {
        Lotto compareLotto = ofLotto(1, 2, 3, 4, 7, 9);
        LottoWinning lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 7, 9}, 10);
        int result = lottoWinning.match(compareLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 당첨번호와_해당로또번호와_보너스가_있는지() {
        LottoWinning lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 7, 9}, 10);
        List<LottoNumber> compareLotto = ofLottoNumbers(1, 2, 3, 4, 7, 10);

        boolean result = lottoWinning.isExistBonus(compareLotto);
        assertThat(result).isTrue();
    }

    public static LottoWinning ofLottoWinning(int[] lottoNumbers, int bonus) {
        List<LottoNumber> numbers = ofLottoNumbers(lottoNumbers);
        return new LottoWinning(numbers, LottoNumber.of(bonus));
    }
}