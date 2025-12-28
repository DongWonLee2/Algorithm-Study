package week01.boj_10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String voca = br.readLine();
        char[] s = new char[101];
        String palindrom = "";

        int i = 1;
        for(char c : voca.toCharArray()) {
            s[i] = c;
            i++;
        }

        for(int j = 100; j > 0; j--) {
            if(s[j] == 0) {
                continue;
            } else {
                palindrom += String.valueOf(s[j]);
            }
        }

        if(voca.equals(palindrom)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
