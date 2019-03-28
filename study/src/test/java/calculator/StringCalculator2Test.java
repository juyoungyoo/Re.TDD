package calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringCalculator2Test {

    StringCalculator2 cal;

    @Before
    public void setUp() throws Exception {
        cal = new StringCalculator2();
    }

    @Test
    public void testAddWhenEmpty() {
        assertEquals(0, cal.add(""));
    }

    @Test
    public void testAddOneNumber() {
        assertEquals(3,cal.add("3"));
    }

    @Test
    public void testAddTwoNumber() {
        assertEquals(3, cal.add("1,2"));
    }

    @Test
    public void testAddThreeNumber() {
        assertEquals(6, cal.add("1,2,3"));
    }

    @Test
    public void testAddWhenTreeNumberNewLine() {
        assertEquals(6, cal.add("1\n2\n3"));
    }

    @Test
    public void testAddWhenCommaAndNewLine() {
        assertEquals(6, cal.add("1,2\n3"));
    }
}