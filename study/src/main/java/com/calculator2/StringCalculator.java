package com.calculator2;

public class StringCalculator {


    public int calculator(String text) {

        if(text == null || text.isEmpty()){
            throw new IllegalAccessError();
        }

        String[] values = text.split(" ");

        int result = Integer.parseInt(values[0]);

        for (int i = 1; i < values.length; i = i+2) {
            int num2 = Integer.parseInt(values[i+1]);
            result = calculator(values[i], result, num2);
        }

        return result;
    }

    public int calculator(String symbol, int num1, int num2){
        if(symbol.equals("+")){
            return num1 + num2;
        }else if(symbol.equals("-")){
            return num1 - num2;
        }else if(symbol.equals("/")){
            return num1 / num2;
        }else if(symbol.equals("*")){
            return num1 * num2;
        }
        throw new IllegalAccessError();
    }

}
