package week04.boj_1202;

import java.util.*;
import java.io.*;

public class Main {

    static class Gem {
        int M, V;
        Gem(int M, int V) {
            this.M = M;
            this.V = V;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Gem[] gems = new Gem[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            gems[i] = new Gem(M, V);
        }

        int[] bags = new int[K];
        for(int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());

            bags[i] = C;
        }

        Arrays.sort(gems, Comparator
                .comparingInt((Gem g) -> g.M));
                // .thenComparingInt(g -> g.V)); pq에서 정렬 일어나니 불필요

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long totalValue = 0;
        int gemIdx = 0;
        for(int b : bags) {
            while(gemIdx < N && gems[gemIdx].M <= b) {
                pq.offer(gems[gemIdx].V);
                gemIdx++;
            }

            if(!pq.isEmpty()){
                totalValue += pq.poll();
            }
        }

        System.out.print(totalValue);
    }
}
