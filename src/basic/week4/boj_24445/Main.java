package basic.week4.boj_24445;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for(int i = 0; i <= N; i++) {
            graph[i].sort(Collections.reverseOrder());
        }

        BFS(R);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }

        System.out.print(sb);
    }
    private static void BFS(int n) {
        visited[n] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while(!q.isEmpty()) {
            int currN = q.poll();
            order[currN] = count++;
            for(int nextN : graph[currN]) {
                if(visited[nextN]) continue;
                q.offer(nextN);
                visited[nextN] = true;
            }
        }
    }
}
