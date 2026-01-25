package week02.boj_14502;

import java.util.*;
import java.io.*;

public class BFS {
    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M;
    static int[][] map; // 원본 지도
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static List<Point> virusList = new ArrayList<>();
    static int maxSafeZone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) virusList.add(new Point(i, j));
            }
        }

        // 벽 세우기 시작 (0개부터)
        setWall(0, 0);

        System.out.println(maxSafeZone);
    }

    // 1. 벽 세우기 (백트래킹)
    private static void setWall(int count, int start) {
        if (count == 3) {
            // 벽 3개가 다 세워지면 BFS로 바이러스 전파 시뮬레이션
            bfs();
            return;
        }

        // 중복 피하기 위해 start 인덱스부터 탐색 (i/M, i%M 테크닉)
        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;

            if (map[r][c] == 0) {
                map[r][c] = 1;          // 벽 세우기
                setWall(count + 1, i + 1);
                map[r][c] = 0;          // 다시 허물기
            }
        }
    }

    // 2. 바이러스 퍼뜨리기 (BFS)
    private static void bfs() {
        Queue<Point> q = new LinkedList<>();
        int[][] copyMap = new int[N][M];

        // 지도 깊은 복사 및 초기 바이러스 큐에 삽입
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }
        for (Point p : virusList) {
            q.add(p);
        }

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                    // 빈칸일 때만 바이러스가 퍼짐
                    if (copyMap[ny][nx] == 0) {
                        copyMap[ny][nx] = 2;
                        q.add(new Point(ny, nx));
                    }
                }
            }
        }

        // 안전 영역 계산
        int safeCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) safeCount++;
            }
        }
        maxSafeZone = Math.max(maxSafeZone, safeCount);
    }
}