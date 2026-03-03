package basic.week7.boj_7576;

import java.util.*;
import java.io.*;

public class Main {
    int m, n;
    int[][] map;
    int[] dy = {-1, 0, 1, 0};
    int[] dx = {0, 1, 0, -1};
    Queue<int[]> q;
    List<int[]> list;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solve();
    }

    private void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        list = new ArrayList<>();
        q = new ArrayDeque<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                int status = Integer.parseInt(st.nextToken());
                map[i][j] = status;
                if(status == 1) q.offer(new int[] {i, j});
            }
        }

        BFS();

        int max = -1;
        boolean canDo = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    canDo = false;
                    break;
                }
                max = Math.max(max, map[i][j]);
            }
            if(!canDo) break;
        }

        if(canDo) {
            System.out.print(max - 1);
        }
        else {
            System.out.print(-1);
        }
    }

    private void BFS() {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];

            for(int i = 0; i < 4; i++) {
                int nextR = currR + dy[i];
                int nextC = currC + dx[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= m) continue;
                if(map[nextR][nextC] != 0) continue;
                map[nextR][nextC] = map[currR][currC] + 1;
                q.offer(new int[] {nextR, nextC});
            }
        }
    }
}
