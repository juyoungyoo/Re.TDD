package com.jump2java.io;

import java.io.FileInputStream;
import java.io.IOException;

// byte
public class FileRead {

    public static void main(String args[]) throws IOException {
        byte[] b = new byte[1024];
        FileInputStream inputStream = new FileInputStream("/Users/juyoungyoo/out.txt");
        inputStream.read(b);
        System.out.println(new String(b));
        inputStream.close();
    }
}
