package week01.boj_10988;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String voca = br.readLine();

        StringBuilder sb = new StringBuilder();

        for(int i = voca.length() - 1; i >=0; i--) {
            sb.append(voca.charAt(i));
        }

        if(voca.equals(sb.toString())){
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
