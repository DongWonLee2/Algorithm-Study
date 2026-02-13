package week05.boj_2294;

import java.io.*;
import java.util.*;

public class Main {
    static int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());

        int[] dp = new int[k+1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for(int i = 1; i <= k; i++){
            for(int v : list){
                if(i - v < 0) break;
                if(dp[i-v] != INF) {
                    dp[i] = Math.min(dp[i], dp[i-v] + 1);
                }
            }
        }

        if (dp[k] == INF) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }
}
