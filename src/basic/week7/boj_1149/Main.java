package basic.week7.boj_1149;

import java.util.*;
import java.io.*;

public class Main {
    int n;
    int[][] cost;
    int[][] dp;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        cost = new int[n][3];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bottomUp();
    }

    private void bottomUp() {
        dp = new int[n][3];
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for(int i = 1; i < n; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        int result = Math.min(dp[n - 1][0], dp[n - 1][1]);
        result = Math.min(result, dp[n - 1][2]);
        System.out.print(result);
    }

    private void topDown() {
        dp = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                Arrays.fill(dp[i], -1);
            }
        }

        int result = Math.min(topDownSolve(0, 0), topDownSolve(0, 1));
        result = Math.min(result, topDownSolve(0, 2));
        System.out.print(result);
    }

    private int topDownSolve(int i, int color) {
        if(i == n - 1) return cost[n - 1][color];
        if(dp[i][color] != -1) return dp[i][color];

        int result = Integer.MAX_VALUE;
        for(int j = 0; j < 3; j++) {
            if(j == color) continue;
            result = Math.min(result, topDownSolve(i + 1, j));
        }

        dp[i][color] = result + cost[i][color];
        return dp[i][color];
    }
}
