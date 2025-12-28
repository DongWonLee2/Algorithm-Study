package week01.boj_2309;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int totalHeight = 0;

        // 입력
        for(int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            totalHeight += dwarfs[i];
        }

        // 정렬
        Arrays.sort(dwarfs);

        int fake1 = -1, fake2 = -1;

        // 수식
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(i == j) {
                    continue;
                }

                if((totalHeight - (dwarfs[i] + dwarfs[j])) == 100){
                    fake1 = i;
                    fake2 = j;
                    break;
                }
            }
            if(fake1 != -1) break; // 중요!
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            if(i == fake1 || i == fake2) {
                continue;
            }
            sb.append(dwarfs[i]).append("\n");
        }
        System.out.print(sb);
    }
}
