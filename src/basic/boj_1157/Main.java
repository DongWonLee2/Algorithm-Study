package basic.boj_1157;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] count = new int[26];
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'a' && c <= 'z') {
                count[c - 'a'] += 1;
            } else {
                count[c - 'A'] += 1;
            }
        }

        int max = -1;
        int mIndex = 0;
        for(int i = 0; i < count.length; i++) {
            if (count[i] > max) {
                max = count[i];
                mIndex = i;
            } else if (count[i] == max && max > 0) {
                mIndex = -1;
            }
        }

        if(mIndex == -1) {
            System.out.print("?");
        } else {
            System.out.print((char) ('A' + mIndex));
        }
    }
}
