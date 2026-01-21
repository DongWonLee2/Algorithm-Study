package week02.boj_1012;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int m, n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new int[n][m];
            for(int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = 1;
            }
            int count = 0;
            for(int a = 0; a < n; a++) {
                for(int b = 0; b < m; b++) {
                    if(map[a][b] == 0 || visited[a][b] != 0) continue;
                    BFS(a, b);
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    private static void BFS(int y, int x) {
        Queue<Point> q = new ArrayDeque<>();
        visited[y][x] = 1;
        q.offer(new Point(x, y));
        while(!q.isEmpty()) {
            Point curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = curr.x + dx[i];
                int ny = curr.y + dy[i];

                if(nx < 0 || nx >= m || ny < 0 || ny >=n) continue;
                if(map[ny][nx] == 0 || visited[ny][nx] != 0) continue;
                visited[ny][nx] = visited[curr.y][curr.x] + 1;
                q.offer(new Point(nx, ny));
            }
        }
    }
}
