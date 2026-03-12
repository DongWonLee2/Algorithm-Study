package basic.week7.boj_3190;

import java.util.*;
import java.io.*;

public class Main {
    int n, k;
    int[][] map;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    HashMap<Integer, Character> info = new HashMap<>();
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 2; // 0: 빈칸, 1: 뱀, 2: 사과
        }

        int l = Integer.parseInt(br.readLine());
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            info.put(t, c);
        }

        System.out.print(solve());
    }

    private int solve() {
        Deque<int []> dq = new ArrayDeque<>();
        int r = 1;
        int c = 1;
        int d = 1;
        int time = 0;
        map[r][c] = 1;
        dq.offerFirst(new int[] {r, c});

        while(true) {
            r = r + dr[d];
            c = c + dc[d];

            time++;
            if(r < 1 || r > n || c < 1 || c > n || map[r][c] == 1) {
                break;
            }

            boolean apple = (map[r][c] == 2);  // 먼저 확인
            dq.offerFirst(new int[] {r, c});
            map[r][c] = 1;
            if(!apple) {
                int[] tail = dq.pollLast();
                map[tail[0]][tail[1]] = 0;
            }

            if(info.containsKey(time)) {
                char dir = info.get(time);
                if(dir == 'L') {
                    d = (d + 3) % 4;
                }
                else {
                    d = (d + 1) % 4;
                }
            }
        }

        return time;
    }
}
