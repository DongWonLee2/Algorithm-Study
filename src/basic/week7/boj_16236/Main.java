package basic.week7.boj_16236;

import java.io.*;
import java.util.*;

public class Main {
    int n;
    int[][] map;
    int[][] visited;
    int[] shark;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 9) shark = new int[] {i, j, 2}; // r, c, 크기
                map[i][j] = num;
            }
        }

        int eatC = 0;
        int time = 0;
        while(true) {
            int w = shark[2];
            visited = new int[n][n];
            List<int []> destination = BFS();
            if(destination.size() == 0) break;
            destination.sort(Comparator
                    .comparingInt((int[] a) -> a[0])
                    .thenComparingInt((int[] a) -> a[1]));

            int[] dest = destination.get(0);
            int destR = dest[0];
            int destC = dest[1];

            eatC++;
            time += visited[destR][destC] - 1;
            if(eatC == w) {
                w++;
                eatC = 0;
            }
            map[shark[0]][shark[1]] = 0; // 원래 상어 위치 비우기
            shark[0] = destR;
            shark[1] = destC;
            shark[2] = w;
            map[shark[0]][shark[1]] = 0; // 먹은 물고기 제거
        }

        System.out.print(time);
    }

    private List<int []> BFS() {
        Queue<int []> q = new ArrayDeque<>();
        q.offer(new int[] {shark[0], shark[1]});
        visited[shark[0]][shark[1]] = 1;
        List<int []> result = new ArrayList<>();
        int findDist = -1;

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
            int currDist = visited[currR][currC];

            // 가장 가까운 물고기들(같은 거리)이 다 모였으면 break;
            if(findDist != -1 && currDist > findDist) break;

            for(int i = 0; i < 4; i++) {
                int nextR = currR + dr[i];
                int nextC = currC + dc[i];

                if(nextR < 0 || nextR >= n || nextC < 0 || nextC >= n) continue;
                if(map[nextR][nextC] > shark[2]) continue;
                if(visited[nextR][nextC] != 0) continue;

                q.offer(new int[] {nextR, nextC});
                visited[nextR][nextC] = visited[currR][currC] + 1;

                if(map[nextR][nextC] != 0 && map[nextR][nextC] < shark[2]) {
                    if(findDist == -1) findDist = visited[nextR][nextC];
                    if(visited[nextR][nextC] == findDist) {
                        result.add(new int[] {nextR, nextC});
                    }
                }
            }
        }

        return result;
    }
}
