package basic.week2.boj_1018;

import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if(c == 'B') {
                    board[i][j] = true;
                }
                else {
                    board[i][j] = false;
                }
            }
        }

        int minCount = 99999;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                int currCount = counting(i, j);
                minCount = Math.min(minCount, currCount);
            }
        }

        System.out.print(minCount);
    }

    private static int counting(int y, int x) {
        int count = 0;

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                boolean expectedColor = ((i + j) % 2 == 0) ? false : true; // W가 시작인 W, B, W, B... 패턴
                if (board[y + i][x + j] != expectedColor) {
                    count++;
                }
            }
        }

        return Math.min(count, 64 - count); // 맨 위 칸이 B인 경우는 모든 칸을 반대로 칠하는 것이니 64 - count
    }
}
