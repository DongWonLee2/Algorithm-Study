package basic.week3.boj_11286;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> Math.abs(a) == Math.abs(b) ?
                        Integer.compare(a, b) : Integer.compare(Math.abs(a), Math.abs(b))
        );
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(pq.isEmpty()) sb.append(0).append("\n");
                else sb.append(pq.poll()).append("\n");
                continue;
            }

            pq.offer(num);
        }

        System.out.println(sb);
    }
}
