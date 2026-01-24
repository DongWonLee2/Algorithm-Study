package week02.boj_10709;

import java.util.*;
import java.io.*;

public class Main {

    static int H;
    static int W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int[][] result = new int[H][W];
        for(int i = 0; i < H; i++) {
            String input = br.readLine();
            for(int j = 0; j < W; j++) {
                if(input.charAt(j) == 'c') {
                    map[i][j] = 1;
                    result[i][j] = 0;
                } else {
                    result[i][j] = -1;
                }
            }
        }

        for(int t = 1; t < W; t++) {
            go(map);
            for(int i = 0; i < H; i++) {
                for(int j = 0; j < W; j++) {
                    if(map[i][j] == 1 && result[i][j] == -1) {
                        result[i][j] = t;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < W; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        /*
            for (int[] row : result) {
                for (int val : row) {
                    sb.append(val).append(" ");
                }
                sb.append("\n");
            }
         */
    }

    private static void go(int[][] map) {
        for (int i = 0; i < H; i++) {
            // 오른쪽 끝(W-1)부터 거꾸로 순회해야 계속 구름 이동하는 걸 막음.
            for (int j = W - 1; j >= 0; j--) {
                if (map[i][j] == 1) {
                    if (j + 1 < W) {
                        map[i][j + 1] = 1;
                    }
                    map[i][j] = 0; // 원래 자리는 빈칸이 됨
                }
            }
        }
    }
}
