package basic.week6.boj_15654;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] nums;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[N];
        result = new int[M];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            nums[i] = num;
            max = Math.max(max, num);
        }
        visited = new boolean[max + 1];
        Arrays.sort(nums);

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if(count == M) {
            for(int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int n : nums) {
            if(!visited[n]) {
                result[count] = n;
                visited[n] = true;
                solve(count + 1);
                visited[n] = false;
            }
        }
    }
}
