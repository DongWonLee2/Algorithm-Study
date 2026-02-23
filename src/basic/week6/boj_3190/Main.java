package basic.week6.boj_3190;

import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int N;
    static HashMap<Integer, Character> infoMap = new HashMap<>();
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c] = 1; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        for(int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            infoMap.put(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0));
        }

        System.out.print(solve());
    }

    private static int solve() {
        Deque<int[]> snake = new ArrayDeque<>();
        snake.offerFirst(new int[]{0, 0});
        map[0][0] = 2; // 뱀

        int time = 0;
        int d = 0;
        int r = 0;
        int c = 0;

        while(true) {
            time++;

            int nr = r + dr[d];
            int nc = c + dc[d];

            // 종료 조건 1
            if(nr >= N || nc >= N || nr < 0 || nc < 0 || map[nr][nc] == 2) {
                break;
            }

            // 이동
            if(map[nr][nc] == 1) {
                map[nr][nc] = 2;
                snake.offerFirst(new int[] {nr, nc});
            } else {
                map[nr][nc] = 2;
                snake.offerFirst(new int[] {nr, nc});
                int[] tail = snake.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            r = nr;
            c = nc;

            if (infoMap.containsKey(time)) {
                if (infoMap.get(time) == 'D') {
                    d = (d + 1) % 4; // 시계 방향
                } else {
                    d = (d + 3) % 4; // 반시계 방향
                }
            }
        }
        return time;
    }
}
