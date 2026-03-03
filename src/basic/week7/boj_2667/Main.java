package basic.week7.boj_2667;

import java.util.*;
import java.io.*;

public class Main {
    int n;
    boolean[][] map;
    boolean[][] visited;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    int count;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                char c = input.charAt(j);
                if(c == '1') map[i][j] = true;
            }
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(map[i][j]) {
                    count = 0;
                    DFS(i, j);
                    if(count != 0) result.add(count);
                }
            }
        }

        result.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        sb.append(result.size()).append("\n");
        for(int i : result) {
            sb.append(i).append("\n");
        }

        System.out.print(sb);
    }

    private void DFS(int r, int c) {
        if(visited[r][c]) return;
        visited[r][c] = true;
        count++;

        for(int i = 0; i < 4; i++) {
            int nextR = r + dy[i];
            int nextC = c + dx[i];

            if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
            if(map[nextR][nextC]) {
                DFS(nextR, nextC);
            }
        }
    }
}
