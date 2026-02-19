package basic.week5.boj_1182;

import java.util.*;
import java.io.*;

public class BitMasking {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        int count = 0;
        for(int i = 1; i < (1 << N); i++) {
            int currSum = 0;
            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) != 0) {
                    currSum += nums[j];
                }
            }
            if(currSum == S) count++;
        }

        System.out.print(count);
    }

}
