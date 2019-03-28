package calculator;


// String 계산기 만들기

/**
 * ,\n  구분자로 split  => String[]
 * String[] -> int[]
 * int[] -> 숫자 합
 * 문자열  -> 숫자 합
 */

public class StringCalculator {


    public String[] split(String text) {
        if (text == null){
            return new String[]{};
        }
        return text.split(",|\n");
    }

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

}
