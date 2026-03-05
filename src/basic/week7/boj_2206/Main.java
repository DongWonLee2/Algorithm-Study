package basic.week7.boj_2206;

import java.util.*;
import java.io.*;

public class Main {
    int n, m;
    int[][] map;
    int[][][] visited;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            String input = br.readLine();
            for(int j = 1; j <= m; j++) {
                map[i][j] = input.charAt(j - 1) - '0';
            }
        }

        visited = new int[n + 1][m + 1][2];

        boolean result = solve();
        if(result) {
            int a = visited[n][m][0];
            int b = visited[n][m][1];
            if(a == 0) System.out.print(b);
            else if(b == 0) System.out.print(a);
            else System.out.print(Math.min(a, b));
        }
        else {
            System.out.print(-1);
        }
    }

    private boolean solve() {
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[] {1, 1, 0});
        visited[1][1][0] = 1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currB = curr[2];
            if(currR == n && currC == m) {
                return true;
            }

            for(int i = 0; i < 4; i++) {
                int nextR = currR + dr[i];
                int nextC = currC + dc[i];

                if(nextR < 1 || nextR >= n + 1 || nextC < 1 || nextC >= m + 1) continue;

                // 길이면?
                if(map[nextR][nextC] == 0 && visited[nextR][nextC][currB] == 0) {
                    q.offer(new int[] {nextR, nextC, currB});
                    visited[nextR][nextC][currB] = visited[currR][currC][currB] + 1;
                }
                // 벽이면?
                else if(map[nextR][nextC] == 1 && currB == 0 && visited[nextR][nextC][1] == 0) {
                    q.offer(new int[] {nextR, nextC, 1});
                    visited[nextR][nextC][1] = visited[currR][currC][0] + 1;
                }
            }
        }

        return false;
    }
}
