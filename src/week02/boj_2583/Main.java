package week02.boj_2583;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int m, n;
    static int areaSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new int[m][n];
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int y = y1; y < y2; y++) {
                for(int x = x1; x < x2; x++) {
                    map[y][x] = 1;
                }
            }
        }

        int count = 0;
        List<Integer> areas = new ArrayList<>();
        for(int y = 0; y < m; y++) {
            for(int x = 0; x < n; x++) {
                if(map[y][x] == 0 && visited[y][x] == 0) {
                    areaSize = 0;
                    DFS(y, x);
                    areas.add(areaSize);
                    count++;
                }
            }
        }

        Collections.sort(areas);
        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for(int a : areas) {
            sb.append(a).append(" ");
        }
        System.out.print(sb);
    }

    private static void DFS(int y, int x) {
        visited[y][x] = 1;
        areaSize++;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
            if(map[ny][nx] == 0 && visited[ny][nx] == 0){
                DFS(ny, nx);
            }
        }
    }
}
