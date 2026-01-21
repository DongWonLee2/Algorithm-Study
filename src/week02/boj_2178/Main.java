package week02.boj_2178;

import java.io.*;
import java.util.*;

public class Main {

    static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int N, M;
    static int[][] map, visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        BFS(0, 0);
        System.out.println(visited[N-1][M-1]);
    }

    private static void BFS(int y, int x) {
        Queue<Point> q = new ArrayDeque<>();
        visited[y][x] = 1;
        q.offer(new Point(y, x));

        while(!q.isEmpty()) {
            Point curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if(map[ny][nx] == 0 || visited[ny][nx] != 0) continue;

                visited[ny][nx] = visited[curr.y][curr.x] + 1;
                q.offer(new Point(ny, nx));
            }
        }
    }
}
