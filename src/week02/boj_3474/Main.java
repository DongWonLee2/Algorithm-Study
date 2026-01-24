package week02.boj_3474;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            int count = 0;
            for(int j = 5; j <= num; j *= 5) {
                count += num / j;

                // 오버플로우 방지
                if(j > num / 5) break;
            }
            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
