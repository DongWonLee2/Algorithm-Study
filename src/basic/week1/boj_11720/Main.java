package basic.week1.boj_11720;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += input.charAt(i) - '0';
        }
        /*
            // for-each 활용
            for (char c : input.toCharArray()) {
                sum += Character.getNumericValue(c);
            }
         */

        System.out.print(sum);
    }
}
