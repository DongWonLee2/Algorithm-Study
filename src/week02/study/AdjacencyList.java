package week02.study;

import java.util.*;

public class AdjacencyList {
    public static void main(String[] args) {
        int V = 4;

        // 1. ArrayList 배열 선언
        ArrayList<Integer>[] adj = new ArrayList[V];

        // 2. 각 배열 요소(리스트) 초기화
        // 자바 배열은 처음에 null로 가득 차 있어서, 각 방에 '빈 리스트'를 넣어줘야 한다.
        // 이 과정을 빼먹으면 NullPointerException(NPE)이 발생한다.
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        // 3. 데이터 추가 (add)
        adj[0].add(1); adj[0].add(2); adj[0].add(3);
        adj[1].add(0); adj[1].add(2);
        adj[2].add(0); adj[2].add(1);
        adj[3].add(0);

        // 4. 출력 로직 (StringBuilder 사용)
        StringBuilder sb = new StringBuilder();

        // 방법 1: for-each)
        for (int i = 0; i < V; i++) {
            sb.append(i).append(" :: ");
            for (int there : adj[i]) {
                sb.append(there).append(" ");
            }
            sb.append("\n");
        }

        sb.append("----------------\n");

        // 방법 2: 인덱스 기반 for문
        for (int i = 0; i < V; i++) {
            sb.append(i).append(" :: ");
            for (int j = 0; j < adj[i].size(); j++) {
                sb.append(adj[i].get(j)).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
