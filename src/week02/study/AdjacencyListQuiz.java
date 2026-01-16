package week02.study;

import java.util.ArrayList;

public class AdjacencyListQuiz {

    static int v = 10;
    static ArrayList<Integer>[] adj =  new ArrayList[v];
    static int[] visited = new int[v];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        for(int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }

        adj[1].add(2); adj[1].add(3);
        adj[2].add(1);
        adj[3].add(1); adj[3].add(4);
        adj[4].add(3);

        for(int i = 0; i < v; i++) {
            // i번 정점을 아직 방문하지 않았고, 연결된 정점이 하나라도 있다면 시작
            if (visited[i] == 0 && !adj[i].isEmpty()) {
                go(i);
            }
        }
        System.out.println(sb);
    }

    private static void go(int from) {
        visited[from] = 1;
        sb.append(from).append("\n");
        // 연결된 이웃(there)들만 바로 확인
        for (int there : adj[from]) {
            if (visited[there] == 0) { // 방문 안 했다면
                go(there); // 바로 이동
            }
        }
    }
}
