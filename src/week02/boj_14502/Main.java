package week02.boj_14502;

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
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static List<Point> virus;
    static int maxCount = -1;
    static int firstWallCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];
        virus = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }

        wall(0, 0, 0);
        System.out.println(maxCount);
    }

    private static void wall(int wallCount, int startY, int startX) {
        if(wallCount == 3) {
            spreadVirus();
            return;
        }
        for (int i = startY; i < N; i++) {
            for (int j = (i == startY ? startX : 0); j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;      // [핵심] 벽 세우기
                    wall(wallCount + 1, i, j);    // 다음 벽 세우러 가기 (재귀)
                    map[i][j] = 0;      // [핵심] 다시 허물기 (백트래킹)
                }
            }
        }
    }

    private static void spreadVirus() {
        // 새로운 조합마다 visited와 지도를 복사해서 사용
        visited = new int[N][M];
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone(); // 깊은 복사
        }

        // 모든 바이러스 위치에서 DFS 시작
        for (Point p : virus) {
            DFS(p, tempMap);
        }

        // 안전 영역 계산
        int count = getSafeZone(tempMap);
        maxCount = Math.max(maxCount, count);
    }

    private static void DFS(Point v, int[][] tempMap) {
        visited[v.y][v.x] = 1;
        for (int i = 0; i < 4; i++) {
            int ny = v.y + dy[i];
            int nx = v.x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
            if (tempMap[ny][nx] == 0 && visited[ny][nx] == 0) {
                tempMap[ny][nx] = 2; // 바이러스 전파 표시
                DFS(new Point(ny, nx), tempMap);
            }
        }
    }

    private static int getSafeZone(int[][] tempMap) {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(tempMap[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
