package com.jump2java.io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream output = new FileOutputStream("/Users/juyoungyoo/out.txt");    // byte
        for (int i = 1; i < 11; i++) {
            String data = i+" 번째 줄입니다.\r\n";
            output.write(data.getBytes());
        }
        output.close();
    }
}