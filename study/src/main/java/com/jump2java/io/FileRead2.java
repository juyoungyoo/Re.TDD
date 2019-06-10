package com.jump2java.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead2 {

    public static void main(String args[]) throws IOException {
        BufferedReader sb = new BufferedReader(new FileReader("/Users/juyoungyoo/out.txt"));
        while (sb.ready()){
            System.out.println(sb.readLine());
        }
        sb.close();
    }
}
