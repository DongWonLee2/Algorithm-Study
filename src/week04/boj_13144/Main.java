package week04.boj_13144;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numArr = new int[N];
        boolean[] visited = new boolean[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        long count = 0;
        int right = 0;
        for(int left = 0; left < N; left++) {
            while(right < N && !visited[numArr[right]]) {
                visited[numArr[right]] = true;
                right++;
            }
            count += right - left;
            visited[numArr[left]] = false;
        }

        System.out.print(count);
    }
}
