package week02.boj_2468;

import java.util.*;
import java.io.*;

public class Improve {

    static int[][] hMap;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        hMap = new int[n][n];
        int maxHeight = 0;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                hMap[i][j] = input;
                if(hMap[i][j] > maxHeight) maxHeight = hMap[i][j];
            }
        }

        int ans = 1;
        for(int h = 1; h < maxHeight; h++) {
            visited = new int[n][n];

            int count = 0;
            for(int y = 0; y < n; y++) {
                for(int x = 0; x < n; x++) {
                    if(hMap[y][x] > h && visited[y][x] == 0) {
                        DFS(y, x, h);
                        count++;
                    }
                }
            }
            if(count > ans) ans = count;
        }
        System.out.print(ans);
    }

    private static void DFS(int y, int x, int h) {
        visited[y][x] = 1;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if(hMap[ny][nx] > h && visited[ny][nx] == 0) {
                DFS(ny, nx, h);
            }
        }
    }
}