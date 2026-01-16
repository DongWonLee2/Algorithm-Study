package week01.boj_2559;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] temperature = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        int max = -999;
        for(int i = 0; i < n - k + 1; i++) {
            int r = 0;
            for(int j = i; j < i + k; j++) {
                r += temperature[j];
            }
            if(r > max) {
                max = r;
            }
        }

        System.out.print(max);
    }
}
