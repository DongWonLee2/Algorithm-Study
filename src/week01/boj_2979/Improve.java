package week01.boj_2979;

import java.io.*;
import java.util.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        int[] timeCount = new int[101];
        int totalPrice = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int leave = Integer.parseInt(st.nextToken());

            for(int t = arrive; t < leave; t++) {
                timeCount[t]++;
            }
        }

        for(int i = 1; i <= 100; i++) {
            switch (timeCount[i]) {
                case 0:
                    break;
                case 1:
                    totalPrice += A;
                    break;
                case 2:
                    totalPrice += B * 2;
                    break;
                case 3:
                    totalPrice += C * 3;
                    break;
            }
        }
        System.out.println(totalPrice);
    }
}
