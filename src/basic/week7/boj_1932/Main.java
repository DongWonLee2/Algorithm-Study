package basic.week7.boj_1932;

import java.util.*;
import java.io.*;

public class Main {
    int n;
    int[][] tri;
    int[][] dp;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        tri = new int[n][500];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int count = st.countTokens();
            for(int j = 0; j < count; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][500];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.print(solve(0, 0));
    }

    private int solve(int d, int i) {
        if(d == n - 1) return tri[n - 1][i];

        if(dp[d][i] != -1) return dp[d][i];

        dp[d][i] = tri[d][i] + Math.max(solve(d + 1, i), solve(d + 1, i + 1));
        return dp[d][i];
    }
}
