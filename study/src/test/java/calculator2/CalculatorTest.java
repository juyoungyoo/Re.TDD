package calculator2;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    Calculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new Calculator();
    }

    @Test
    public void 사칙연산_덧셈() {
        int result = cal.add(1,3);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 사칙연산_뺄셈() {
        int result = cal.minus(4,2);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void 사칙연산_곱셈() {
        int result = cal.cross(4,2);
        assertThat(result).isEqualTo(8);
    }

    @Test
    public void 사칙연산_나눗셈() {
        int result = cal.division(4,2);
        assertThat(result).isEqualTo(2);
    }
}