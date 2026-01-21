package week02.boj_2468;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] hMap;
    static int[][] rMap;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        hMap = new int[n][n];
        int height = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                hMap[i][j] = input;
                if(input > height) height = input;
            }
        }

        int ans = 0;
        for(int i = 0; i < height; i++) {
            rMap = new int[n][n];
            visited = new int[n][n];
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < n; x++) {
                    if(hMap[y][x] > i) rMap[y][x] = 1;
                }
            }

            int count = 0;
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < n; x++) {
                    if(rMap[y][x] == 1 && visited[y][x] == 0) {
                        DFS(y, x);
                        count++;
                    }
                }
            }
            if(count > ans) ans = count;
        }
        System.out.print(ans);
    }

    private static void DFS(int y, int x) {
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(rMap[ny][nx] == 1 && visited[ny][nx] == 0) {
                DFS(ny, nx);
            }
        }
    }
}
