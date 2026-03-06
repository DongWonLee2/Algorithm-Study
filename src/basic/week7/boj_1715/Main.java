package basic.week7.boj_1715;

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

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while(pq.size() >= 2) {
            int a = pq.poll();
            int b = pq.poll();
            int sum = a + b;
            total += sum;
            pq.offer(sum);
        }

        System.out.print(total);
    }
}
