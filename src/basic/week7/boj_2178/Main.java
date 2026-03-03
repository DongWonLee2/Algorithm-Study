package basic.week7.boj_2178;

import java.util.*;
import java.io.*;

public class Main {
    int n, m;
    boolean[][] map;
    int[][] visited;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];
        visited = new int[n][m];

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if(c == '1') {
                    map[i][j] = true;
                }
            }
        }

        BFS(0, 0);
        System.out.print(visited[n - 1][m - 1]);
    }

    private void BFS(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {r, c});
        visited[r][c] = 1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            if(currR == n - 1 && currC == m - 1) {
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nextR = currR + dy[i];
                int nextC = currC + dx[i];

                if(nextR < 0 || nextR >= n || nextC < 0|| nextC >= m) continue;
                if(!map[nextR][nextC]) continue;
                if(visited[nextR][nextC] != 0) continue;
                q.offer(new int[] {nextR, nextC});
                visited[nextR][nextC] = visited[currR][currC] + 1;
            }
        }
    }
}
