package com.tdd.baseballgame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AnswerTest {

    @Test
    public void 쉽표를_구분으로_숫자생성한다() {
        String input = "1,2,3";
        Answer result = Answer.of(input);
        assertThat(result.getNumbers()).isInstanceOf(Numbers.class);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 구분자가_쉼표가_아닐시_에러난다() {
        String input = "1|3|3";
        Answer.of(input);
    }

    // todo : more
}
