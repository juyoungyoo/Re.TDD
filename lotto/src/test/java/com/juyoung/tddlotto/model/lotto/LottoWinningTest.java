package com.juyoung.tddlotto.model.lotto;

import com.juyoung.tddlotto.model.Lotto;
import com.juyoung.tddlotto.model.LottoNumber;
import com.juyoung.tddlotto.model.WinningLotto;
import org.junit.Test;

import java.util.List;

import static com.juyoung.tddlotto.model.lotto.LottoTest.ofLotto;
import static com.juyoung.tddlotto.model.lotto.LottoTest.ofLottoNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningTest {

    @Test
    public void 당첨번호를_생성한다() {
        WinningLotto lottoWinning = WinningLotto.of();
        assertThat(lottoWinning.size()).isEqualTo(7);
        assertThat(lottoWinning.getBonus()).isNotNull();
    }

    @Test
    public void 당첨번호와_해당로또번호와_일치하는_갯수() {
        Lotto compareLotto = ofLotto(1, 2, 3, 4, 7, 9);
        WinningLotto lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 7, 9}, 10);
        int result = lottoWinning.match(compareLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void 당첨번호와_해당로또번호와_보너스가_있는지() {
        WinningLotto lottoWinning = ofLottoWinning(new int[]{1, 2, 3, 4, 7, 9}, 10);
        List<LottoNumber> compareLotto = ofLottoNumbers(1, 2, 3, 4, 7, 10);

        boolean result = lottoWinning.isExistBonus(compareLotto);
        assertThat(result).isTrue();
    }

    public static WinningLotto ofLottoWinning(int[] lottoNumbers, int bonus) {
        List<LottoNumber> numbers = ofLottoNumbers(lottoNumbers);
        return new WinningLotto(numbers, LottoNumber.of(bonus));
    }
}