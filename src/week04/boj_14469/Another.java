package week04.boj_14469;

import java.util.*;
import java.io.*;

public class Another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cows = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
            // cows[i] = new int[] {at, checkT};
        }

        // 2. 정렬 (도착 시간 기준 오름차순)
        // Arrays.sort(cows, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(cows, Comparator.comparingInt(a -> a[0]));

        int currT = 0;
        for (int i = 0; i < N; i++) {
            int arrival = cows[i][0];
            int duration = cows[i][1];

            // 현재 시간보다 소가 늦게 도착하면, 소가 올 때까지 점프
            if (currT < arrival) {
                currT = arrival;
            }

            currT += duration;
        }

        System.out.print(currT);
    }
}