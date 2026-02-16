package basic.week4.boj_24479;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count = 1;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        order = new int[N + 1];
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    private static void DFS(int n) {
        visited[n] = true;
        order[n] = count++;

        for(int nextN : graph[n]) {
            if(!visited[nextN]) DFS(nextN);
        }
    }
}
