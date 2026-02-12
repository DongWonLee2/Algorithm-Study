package week05.boj_2240;

import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int[] trees;
    static int[][][] dp;
    static int INF = -10000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        trees = new int[T];
        for(int i = 0; i < T; i++) {
            trees[i] = Integer.parseInt(br.readLine());
        }

        // 초기화
        dp = new int[T + 1][W + 1][2];
        for(int i = 0; i <= T; i++) {
            for(int j = 0; j <= W; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // 초기에 나무 1에 가만히 있는 경우, 나무 2로 움직인 경우
        int result = Math.max(solve(0, W, 0), solve(0, W - 1, 1));
        System.out.println(result);
    }

    private static int solve(int time, int count, int tree) {
        // 기저사례 1: 이동횟수를 다 쓴 상태로 불가능한 상황
        if(count < 0) return INF;

        // 기저사례 2: 시간 종료
        if(time == T) return 0;

        // 메모이제이션
        if(dp[time][count][tree] != -1) return dp[time][count][tree];

        // tree를 0, 1로 구분하기 때문에 -1함
        int score = (tree == trees[time] - 1 ? 1 : 0);

        return dp[time][count][tree] =
                Math.max(solve(time + 1, count - 1, tree ^ 1),
                        solve(time + 1, count, tree)) + score;
    }
}
