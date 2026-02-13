package week05.boj_2293;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];
        Arrays.fill(dp, 0);
        dp[0] = 1;

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        list.sort(Comparator.naturalOrder());


        for(int v : list) {
            for(int i = v; i <= k; i++) {
                dp[i] += dp[i-v];
            }
        }

        System.out.println(dp[k]);
    }
}
