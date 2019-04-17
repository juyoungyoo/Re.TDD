package com.jump2java.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWrite {

    public static void main(String[] args) throws IOException {
        PrintWriter output = new PrintWriter("/Users/juyoungyoo/out.txt");    // byte
        for (int i = 1; i < 12; i++) {
            String data = i+"번째 줄입니다";
            output.println(data);
        }
        output.close();

        PrintWriter output2 = new PrintWriter(new FileWriter("/Users/juyoungyoo/out.txt",true));
        output2.println("내용 추가!!!");
        output2.close();
    }
}