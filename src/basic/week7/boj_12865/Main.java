package basic.week7.boj_12865;

import java.util.*;
import java.io.*;

public class Main {
    int n, k;
    List<int []> things;
    int[][] dp;
    int INF = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        things = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            things.add(new int[] {w, v});
        }

        dp = new int[n][k + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int result = solve(0, 0);
        System.out.print(result);
    }

    private int solve(int num, int w) {
        if(num == n || w > k) return 0;

        if(dp[num][w] != -1) return dp[num][w];

        int[] thing = things.get(num);

        if(w + thing[0] > k) {
            dp[num][w] = solve(num + 1, w);
        }
        else {
            dp[num][w] = Math.max(solve(num + 1, w + thing[0]) + thing[1], solve(num + 1, w));
        }

        return dp[num][w];
    }
}
