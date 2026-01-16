package week02.study;

public class AdjacencyMatrix {
    // 1. 전역 변수 설정
    static final int V = 10;
    static boolean[][] a = new boolean[V][V];
    static boolean[] visited = new boolean[V];
    static StringBuilder sb = new StringBuilder();

    // 2. DFS 함수
    private static void go(int from) {
        visited[from] = true; // 방문 표시
        sb.append(from).append("\n"); // 출력할 내용을 StringBuilder에 담기

        for (int i = 0; i < V; i++) {
            // 방문했으면 건너뛰기
            if (visited[i]) continue;

            // 연결되어 있다면 (인접 행렬 값이 true라면) 방문
            if (a[from][i]) {
                go(i);
            }
        }
    }

    public static void main(String[] args) {
        // 3. 간선 설정 (1-2, 1-3, 3-4 연결)
        a[1][2] = true; a[1][3] = true; a[3][4] = true;
        a[2][1] = true; a[3][1] = true; a[4][3] = true;

        // 4. 모든 정점을 돌며 방문하지 않았고 간선이 있는 경우 DFS 시작
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (a[i][j] && !visited[i]) {
                    go(i);
                }
            }
        }

        // 5. 최종 결과 출력
        System.out.print(sb.toString());
    }
}
