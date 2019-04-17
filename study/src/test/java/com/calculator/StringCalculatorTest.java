package com.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {


    private StringCalculator cal;

    @Before
    public void setUp() throws Exception {
        cal = new StringCalculator();
    }

    @Test
    public void testSplit() {
        String[] result = cal.split("1");
        Assert.assertArrayEquals(new String[]{"1"}, result);
        result = cal.split("");
        Assert.assertArrayEquals(new String[]{""}, result);
        result = cal.split( null);  // Nullpoint Error
        Assert.assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void testSplitWhenNewLine() {
        String[] result = cal.split("1\n2\n3");
        Assert.assertArrayEquals(new String[]{"1","2","3"}, result);
    }
    @Test
    public void testSplitWhenNewLineAndComma() {
        String[] result = cal.split("1,2\n3");
        Assert.assertArrayEquals(new String[]{"1","2","3"}, result);
    }

    // String Converter Int


    @Test
    public void testToInt() {
        int[] result = cal.toInt(new String[]{"1","2"});
        Assert.assertArrayEquals(new int[]{1,2}, result);

        result = cal.toInt(new String[]{});
        Assert.assertArrayEquals(new int[]{}, result);

        result = cal.toInt(null);
        Assert.assertArrayEquals(new int[]{}, result);
    }
}