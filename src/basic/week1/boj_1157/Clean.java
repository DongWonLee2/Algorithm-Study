package basic.week1.boj_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Clean {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] count = new int[26];
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 'a' && c <= 'z') {
                count[c - 'a'] += 1;
            } else {
                count[c - 'A'] += 1;
            }
        }

        int max = -1;
        char result = '?';
        for(int i = 0; i < 26; i++) {
            if(count[i] > max) {
                max = count[i];
                result = (char) ('A' + i);
            } else if(max == count[i]) {
                result = '?';
            }
        }

        System.out.print(result);
    }
}
