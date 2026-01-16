package week01.boj_1940;

import java.io.*;
import java.util.*;

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(items);

        int left = 0;
        int right = items.length - 1;
        int count = 0;
        while(left < right) {
            int sum = items[left] + items[right];
            if(sum == m) {
                count++;
                left++;
                right--;
            }
            else if(sum < m) {
                left++;
            }
            else {
                right--;
            }
        }

        System.out.println(count);
    }
}
