package week05.boj_12865;

import java.util.*;
import java.io.*;

public class Main {

    static class Obj{
        int w, v;
        Obj(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Obj> objList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            objList.add(new Obj(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] dp = new int[K + 1];
        int max = 0;
        for(Obj o : objList) {
            int currW = o.w;
            int currV = o.v;

            for(int i = K; i >= currW; i--) {
                dp[i] = Math.max((dp[i - currW] + currV), dp[i]);
                max = Math.max(max, dp[i]);
            }
        }

        System.out.print(max);
    }
}
