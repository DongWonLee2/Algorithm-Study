package week05.boj_2098;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] W;
    static int N;
    static int INF = 100000000;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        dp = new int[N][1 << N];
        for(int i = 0; i < N; i++){
            // 초기화
            Arrays.fill(dp[i], -1);
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(go(0, 1));

    }

    private static int go(int curr, int visited) {
        // 기저사례: 다 방문했을 때
        if((1 << N) - 1 == visited) {
            if(W[curr][0] == 0) return INF; // 큰 값을 return해 불가능하도록 만듦.
            return W[curr][0];
        }

        // 메모이제이션
        if(dp[curr][visited] != -1) return dp[curr][visited];

        // 로직
        dp[curr][visited] = INF;
        for(int next = 0; next < N; next++){
            // 방문했는지와 갈 수 있는지 체크
            if((visited & (1 << next)) == 0 && W[curr][next] != 0) {
                int res = go(next, visited | (1 << next)) + W[curr][next];
                dp[curr][visited] = Math.min(res, dp[curr][visited]);
            }
        }
        return dp[curr][visited];
    }
}
