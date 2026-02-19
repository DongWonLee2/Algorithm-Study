package basic.week5.boj_1182;

import java.util.*;
import java.io.*;

public class Main {
    static int S, N;
    static int[] nums;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        solve(0, 0);
        if(S == 0) count--;
        System.out.print(count);

    }

    private static void solve(int idx, int sum) {
        if(idx == N) {
            if(sum == S) count++;
            return;
        }

        solve(idx + 1, sum + nums[idx]);
        solve(idx + 1, sum);
    }
}
