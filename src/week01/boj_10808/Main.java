package week01.boj_10808;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alphabetCount = new int[26];

        for(char c : s.toCharArray()) {
            alphabetCount[c - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int count : alphabetCount) {
            sb.append(count).append(" ");
        }

        System.out.print(sb);
    }
}
