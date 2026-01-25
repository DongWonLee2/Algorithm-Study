package week02.boj_2636;

import java.util.*;
import java.io.*;

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
    static int[][] cheese;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Point> meltCheese = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastCheese = 0;
        while(true) {
            // 매 시간마다 초기화
            visited = new int[N][M];
            meltCheese.clear();

            BFS(0, 0);
            if(meltCheese.isEmpty()) break;

            int meltingCheese = 0;
            for(Point p : meltCheese) {
                meltingCheese++;
                int y = p.y;
                int x = p.x;
                cheese[y][x] = 0;
            }
            lastCheese = meltingCheese;
            time++;
        }
        System.out.println(time);
        System.out.println(lastCheese);
    }

    private static void BFS(int y, int x) {
        Queue<Point> q = new ArrayDeque<>();
        visited[y][x] = 1;
        q.offer(new Point(y, x));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            for(int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                if(ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if(cheese[ny][nx] == 0 && visited[ny][nx] == 0) {
                    q.offer(new Point(ny, nx));
                    visited[ny][nx] = 1;
                }
                else if(cheese[ny][nx] == 1 && visited[ny][nx] == 0) {
                    meltCheese.add(new Point(ny, nx));
                    visited[ny][nx] = 1; // 치즈 녹는 리스트에 넣었음 표시
                }
            }
        }
    }
}
