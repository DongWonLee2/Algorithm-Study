package basic.boj_1417;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 후보가 다솜이 혼자라면 뺏을 사람이 없으므로 바로 0 출력
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int dasom = Integer.parseInt(br.readLine());
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 1; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0;
        while(!pq.isEmpty() && dasom <= pq.peek()) {
            int a = pq.poll();
            dasom++;
            pq.offer(a - 1);
            count++;
        }

        System.out.print(count);
    }
}
