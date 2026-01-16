package week01.boj_2559;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 1. 누적합을 담을 배열 (1번 인덱스부터 쓰면 계산이 편해!)
        int[] psum = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            // 현재까지의 합 = 이전까지의 합 + 현재 값
            psum[i] = psum[i - 1] + temp;
        }

        // 2. 최댓값 초기화 (가능한 가장 작은 값으로)
        int max = Integer.MIN_VALUE;

        // 3. 구간합 계산 (O(N)만에 끝남!)
        // i번째부터 k개 떨어진 곳까지의 합: psum[i] - psum[i - k]
        for (int i = k; i <= n; i++) {
            int currentSum = psum[i] - psum[i - k];
            if (currentSum > max) {
                max = currentSum;
            }
        }

        System.out.print(max);
    }
}
