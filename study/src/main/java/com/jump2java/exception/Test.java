package com.jump2java.exception;

public class Test {
    public void sayNick(String nick) throws FoolException {
//        try {
            if("fool".equals(nick)) {
               throw new FoolException();
            }
            System.out.println("당신의 별명은 "+nick+" 입니다.");
//        } catch (FoolException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws FoolException {
        Test test = new Test();
        test.sayNick("fool");
        test.sayNick("genious");
    }
}

