package com.jump2java.io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrite {

    public static void main(String[] args) throws IOException {
        FileWriter output = new FileWriter("/Users/juyoungyoo/out.txt");    // byte
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < 12; i++) {
            sb.append(i+" 번째 줄입니다.\n");
        }
        output.write(sb.toString());
        output.close();

        // 파일에 내용 추가하기
        FileWriter output2 = new FileWriter("/Users/juyoungyoo/out.txt",true);  // 해당 파일있으면 불러오기 (false : override)
        output2.write("내용 추가!!");
        output2.close();
    }
}