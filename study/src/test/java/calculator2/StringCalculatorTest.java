package calculator2;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {


    private StringCalculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new StringCalculator();
    }

    // null, 공백 입력시 예외처리 및 테스트 구현
    @Test(expected = IllegalAccessError.class)
    public void 입력값_Null() {
        cal.calculator(null);
    }

    @Test(expected = IllegalAccessError.class)
    public void 입력값_공백일시_Exception() {
        cal.calculator("");
    }

    @Test
    public void 덧셈() {
        int result = cal.calculator("1 + 3");
        assertThat(result).isEqualTo(4);
    }
    @Test
    public void 뺄셈() {
        int result = cal.calculator("6 - 3");
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void 곱셈() {
        int result = cal.calculator("1 * 3");
        assertThat(result).isEqualTo(3);
    }
    @Test
    public void 나눗셈() {
        int result = cal.calculator("4 / 2");
        assertThat(result).isEqualTo(2);
    }


    @Test
    public void 사칙연산() {
        int result = cal.calculator("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(10);
    }
}
