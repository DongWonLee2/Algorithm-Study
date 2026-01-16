package week02.study;

import java.io.*;
import java.util.*;

public class BFSQuiz2 {
    // 1. 좌표를 담을 클래스 정의 (static을 붙여야 main에서 바로 사용 가능!)
    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int n, m;
    static int[][] map, visited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 시작/종료 지점 입력 (sy, sx, ey, ex)
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        BFS(sy, sx);

        System.out.println(visited[ey][ex]);
    }

    static void BFS(int sy, int sx) {
        Queue<Point> q = new ArrayDeque<>();

        visited[sy][sx] = 1;
        q.offer(new Point(sy, sx));

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= m) continue;
                if (map[ny][nx] == 0 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[curr.y][curr.x] + 1;
                q.offer(new Point(ny, nx));
            }
        }
    }
}