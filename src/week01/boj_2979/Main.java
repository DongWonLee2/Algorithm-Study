package week01.boj_2979;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] prices = new int[3];
        int[][] times = new int[3][100];
        int totalPrice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
//        for(int i = 0; i < st.countTokens()+1; i++) {
//            prices[i] = Integer.parseInt(st.nextToken());
//        }
        for(int i = 0; i < 3; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int arrive = 0;
        int leave = 0;
        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arrive = Integer.parseInt(st.nextToken());
            leave = Integer.parseInt(st.nextToken());
            for(int j = arrive - 1; j < leave - 1; j ++) {
                times[i][j] += 1;
            }
        }

        for(int j = 0; j < 100; j++) {
            int sum = 0;
            for(int i = 0; i < 3; i++) {
                sum += times[i][j];
            }
            switch (sum) {
                case 0:
                    break;
                case 1:
                    totalPrice += prices[0];
                    break;
                case 2:
                    totalPrice += prices[1] * 2;
                    break;
                case 3:
                    totalPrice += prices[2] * 3;
                    break;
            }
        }
        System.out.println(totalPrice);
    }
}
