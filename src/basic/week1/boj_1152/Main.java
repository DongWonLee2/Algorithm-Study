package basic.week1.boj_1152;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);
//        int count = 0;
//        while(st.hasMoreTokens()) {
//            st.nextToken(); // 포인터 이동
//            count++;
//        }
//
//        System.out.print(count);
        // 메서드 사용(메모리 절반, 시간 절약)
        System.out.print(st.countTokens());
    }
}
