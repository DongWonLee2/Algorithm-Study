package week02.boj_10709;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                if (s.charAt(j) == '.') {
                    map[i][j] = -1; // 구름이 없는 곳
                } else {
                    map[i][j] = 0;  // 구름이 있는 곳
                }
            }
        }

        // 전진 탐색
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                // 구름을 발견했을 때만 그 오른쪽 칸들을 채움
                if (map[i][j] == 0) {
                    int cnt = 1;
                    while (j + 1 < W && map[i][j + 1] == -1) {
                        map[i][j + 1] = cnt++;
                        j++;
                    }
                }
            }
        }

        StringBuilder resultSb = new StringBuilder();
        for (int[] row : map) {
            for (int val : row) {
                resultSb.append(val).append(" ");
            }
            resultSb.append("\n");
        }
        System.out.print(resultSb);
    }
}