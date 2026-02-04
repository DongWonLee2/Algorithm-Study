package basic.boj_2798;

import java.io.*;
import java.util.*;

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);

        int result = 0;
        for(int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;

            while(left < right) {
                int sum = cards[i] + cards[left] + cards[right];

                if(sum == M) {
                    System.out.print(sum);
                    return;
                }
                else if(sum > M) {
                    right--;
                }
                else {
                    result = Math.max(sum, result);
                    left++;
                }
            }
        }

        System.out.print(result);
    }
}
