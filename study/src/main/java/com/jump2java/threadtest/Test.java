package com.jump2java.threadtest;

public class Test extends Thread{
    int seq;
    public Test(int seq){
        this.seq = seq;
    }
    public void run(){
        System.out.println("thread run start : " + this.seq);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread run stop : " + this.seq);
    }

    public static void main(String[] args) {
        Test test;
        for (int i = 0; i < 10; i++) {
            test = new Test(i);
            test.start();   // Thread는 start 실행 시 run 메소드가 수행되도록 구현되어있다.
        }
        System.out.println("main class end.");
    }
}
