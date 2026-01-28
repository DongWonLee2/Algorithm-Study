package week03.boj_2589;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int maxDist = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                char c = input.charAt(j);
                if(c == 'W') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 1) {
                    int currDist = BFS(new Point(i, j));
                    maxDist = Math.max(maxDist, currDist);
                }
            }
        }

        System.out.print(maxDist);
    }

    private static int BFS(Point p) {
        Queue<Point> q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], 0); // 각 행(1차원 배열)을 꺼내서 채우기
        }
        visited[p.y][p.x] = 1;
        q.offer(p);
        int localMax = 0;
        while(!q.isEmpty()) {
            Point curr = q.poll();

            localMax = Math.max(localMax, visited[curr.y][curr.x] - 1);

            for(int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(map[ny][nx] == 1 && visited[ny][nx] == 0) {
                    q.offer(new Point(ny, nx));
                    visited[ny][nx] = visited[curr.y][curr.x] + 1;
                }
            }
        }
        return localMax;
    }
}
