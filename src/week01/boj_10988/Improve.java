package week01.boj_10988;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String voca = br.readLine();

        // String -> StringBuilder로 변환 -> reverse() 실행 -> 다시 String으로 변환
        String reversed = new StringBuilder(voca).reverse().toString();

        if (voca.equals(reversed)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
