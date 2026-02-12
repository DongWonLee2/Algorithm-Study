package week05.boj_17070;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[][] map;
    static int[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                if(st.nextToken().equals("0")){
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }

        // dp 초기화: -1
        dp = new int[N + 1][N + 1][3];
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(1, 2, 0));
    }

    private static int solve(int r, int c, int s) {
        // 기저사례 1: 도착했을 때
        if(r == N && c == N) return 1;

        // 메모이제이션
        if(dp[r][c][s] != -1) return dp[r][c][s];

        // 로직 -> 대각선일 경우 문제 조건에 따라 3개의 칸을 확인해야 함.
        int res = 0;
        switch (s) {
            case 0:
                // 가로
                if(c + 1 <= N && map[r][c + 1]) {
                    res += solve(r, c + 1, 0);
                }
                // 대각선
                if(r + 1 <= N && c + 1 <= N && map[r + 1][c + 1] && map[r][c + 1] && map[r + 1][c]) {
                    res += solve(r + 1, c + 1, 2);
                }
                break;
            case 1:
                // 세로
                if(r + 1 <= N && map[r + 1][c]) {
                    res += solve(r + 1, c, 1);
                }
                // 대각선
                if(r + 1 <= N && c + 1 <= N && map[r + 1][c + 1] && map[r + 1][c] && map[r][c + 1]) {
                    res += solve(r + 1, c + 1, 2);
                }
                break;
            case 2:
                // 가로
                if(c + 1 <= N && map[r][c + 1]) {
                    res += solve(r, c + 1, 0);
                }
                // 세로
                if(r + 1 <= N && map[r + 1][c]) {
                    res += solve(r + 1, c, 1);
                }
                // 대각선
                if(r + 1 <= N && c + 1 <= N && map[r + 1][c + 1] && map[r + 1][c] && map[r][c + 1]) {
                    res += solve(r + 1, c + 1, 2);
                }
                break;
        }

        return dp[r][c][s] = res;
    }
}