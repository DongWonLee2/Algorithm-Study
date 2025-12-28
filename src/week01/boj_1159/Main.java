package week01.boj_1159;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] alphabetCount = new int[26];
        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            char first = name.charAt(0);
            alphabetCount[first - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            if(alphabetCount[i] >= 5) {
                char c = (char) (i + 97);
                sb.append(String.valueOf(c));
            }
        }

        if(sb.length() > 0) {
            System.out.println(sb);
        } else {
            System.out.println("PREDAJA");
        }
    }
}
