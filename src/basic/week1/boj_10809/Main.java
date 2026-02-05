package basic.week1.boj_10809;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

//        int index = 0;
//        for(char c : s.toCharArray()) {
//            if(alpha[c - 'a'] == -1) {
//                alpha[c - 'a'] = index;
//            }
//            index++;
//        }

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(alpha[ch - 'a'] == -1) {
                alpha[ch - 'a'] = i;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            sb.append(alpha[i]).append(" ");
        }
        System.out.print(sb);
    }
}
