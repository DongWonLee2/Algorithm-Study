package week02.study;

import java.util.*;

public class BFS {
    static ArrayList<Integer>[] adj = new ArrayList[100];
    static int[] visited = new int[100];
    static int[] nodeList = {10, 12, 14, 16, 18, 20, 22, 24};

    public static void main(String[] args) {
        // 인접 리스트 초기화
        for (int i = 0; i < 100; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[10].add(12); adj[10].add(14); adj[10].add(16);
        adj[12].add(18); adj[12].add(20);
        adj[20].add(22); adj[20].add(24);

        BFS(10);

        StringBuilder sb = new StringBuilder();
        for (int i : nodeList) {
            sb.append(i).append(" : ").append(visited[i]).append("\n");
        }
        // 최단 거리는 시작지점을 1로 잡았으므로 -1
        sb.append("10번으로부터 24번까지 최단거리는 : ").append(visited[24] - 1).append("\n");

        System.out.print(sb);
    }

    private static void BFS(int here) {
        Queue<Integer> q = new ArrayDeque<>();

        visited[here] = 1; // 시작 지점 방문 표시
        q.offer(here); // 큐에 넣기

        while (!q.isEmpty()) {
            int curr = q.poll(); // 맨 앞에서 빼기

            for (int there : adj[curr]) {
                // 이미 방문했다면 건너뛰기
                if (visited[there] != 0) continue;

                // 현재 거리에서 +1을 하여 최단 거리 갱신
                visited[there] = visited[curr] + 1;
                q.offer(there); // 다음 탐색을 위해 큐에 삽입
            }
        }
    }
}