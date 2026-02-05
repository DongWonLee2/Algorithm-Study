package basic.week1.boj_1316;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] alpha = new boolean[26];

        int count = 0;
        for(int i = 0; i < N; i++) {
            Arrays.fill(alpha, false);
            String input = br.readLine();
            char lastChar = 0;
            boolean isGroupWord = true;
            for(int j = 0; j < input.length(); j++) {
                char c = input.charAt(j);
                if(alpha[c - 'a'] == false) {
                    alpha[c - 'a'] = true;
                    lastChar = c;
                    continue;
                } else if(alpha[c - 'a'] == true && lastChar == c) {
                    continue;
                } else {
                    isGroupWord = false;
                    break;
                }
            }
            if(isGroupWord) count++;
        }
        System.out.print(count);
    }
}
