package week01.boj_11655;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        ROT13(s);
    }

    private static void ROT13(String input) {
        StringBuilder sb = new StringBuilder();
        for(char i : input.toCharArray()) {
            if(i >= 'a' && i <= 'z') {
                i += 13;
                if(i > 'z') {
                    i -= 26;
                }
                sb.append(i);
            }
            else if(i >= 'A' && i <= 'Z') {
                i += 13;
                if(i > 'Z') {
                    i -= 26;
                }
                sb.append(i);
            }
            else{
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}
