package week04.boj_3273;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int X = Integer.parseInt(br.readLine());

        Arrays.sort(numArr);

        int left = 0;
        int right = N - 1;
        int count = 0;
        while(left < right) {
            int sum = numArr[left] + numArr[right];

            if(sum > X) {
                right--;
            }
            else if(sum < X) {
                left++;
            }
            else {
                count++;
                left++;
                right--;
            }
        }

        System.out.print(count);
    }
}
