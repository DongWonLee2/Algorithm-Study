package basic.week7.boj_1931;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<int []> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            meetings.add(new int[] {s, e});
        }

        meetings.sort(Comparator
                .comparingInt((int[] m) -> m[1])
                .thenComparingInt((int[] m) -> m[0]));

        int time = 0;
        int count = 0;
        for(int[] m : meetings) {
            if(time <= m[0]) {
                time = m[1];
                count++;
            }
        }

        System.out.print(count);
    }
}
