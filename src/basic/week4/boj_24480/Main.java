package basic.week4.boj_24480;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] orders;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        orders = new int[N + 1];
        graph = new ArrayList[N + 1];
        for(int i = 0; i <=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 0; i <=N; i++) {
            graph[i].sort(Collections.reverseOrder());
            // Collections.sort(graph[i], Collections.reverseOrder());
            // graph[i].sort((a, b) -> Integer.compare(b, a));
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <=N; i++) {
            sb.append(orders[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void DFS(int n) {
        visited[n] = true;
        orders[n] = count++;

        for(int nextN : graph[n]) {
            if(!visited[nextN]) DFS(nextN);
        }
    }
}
