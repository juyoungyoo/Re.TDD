package com.calculator;


// String 계산기 만들기

/**
 * ,\n  구분자로 split  => String[]
 * String[] -> int[]
 * int[] -> 숫자 합
 * 문자열  -> 숫자 합
 */

public class StringCalculator2 {

    public int[] toInt(String[] val) {
        if(val == null){
            return new int[]{};
        }
        int[] numbers = new int[val.length];
        for(int i=0; i < numbers.length; i++){
            numbers[i] = Integer.parseInt(val[i]);
        }
        return numbers;
    }

    public int add(String text) {
        if(text.isEmpty()){
            return 0;
        }
        String[] numbers = text.split(",|\n");
        int[] values = toInt(numbers);
        return sum(values);
    }

    private int sum(int[] numbers) {
        int sum = 0;
        for (int i=0; i<numbers.length; i++){
            sum += numbers[i];
        }
        return sum;
    }
}
