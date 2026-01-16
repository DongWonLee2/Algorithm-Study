package week01.boj_1940;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] items = new int[n];
        for(int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        // solve
        int count = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(items[i] + items[j] == m) {
                    count++;
                } else {
                    continue;
                }
            }
        }

        System.out.println(count);
    }
}
