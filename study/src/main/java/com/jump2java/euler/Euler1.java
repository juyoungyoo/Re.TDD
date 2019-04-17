package com.jump2java.euler;

// 10 미만의 자연수에서 3과 5의 배수를 구하면 3, 5, 6, 9이다.
// 이들의 총합은 23이다.
// 1000미만의 자연수에서 3, 5의 배수의 총합을 구하라.

import com.calculator2.Calculator;

public class Euler1 {

    private int maxNum;
    private int result = 0;

    public Euler1(int maxNum) {
        this.maxNum = maxNum;
        this.calculated();
    }

    public int getResult() {
        return result;
    }

    private void calculated() {
        for (int i = 1; i < maxNum; i++) {
            if(isMultiple3Or5(i)){
                this.result += i;
            }
        }
    }

    private boolean isMultiple3Or5(int number){
        if( number  % 3  == 0 || number % 5 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "reseult : " + this.getResult();
    }

    public static void main(String[] args) {
        Euler1 euler1 = new Euler1(10);
        System.out.println(euler1);
        System.out.println(new Euler1(1000));
    }
}
