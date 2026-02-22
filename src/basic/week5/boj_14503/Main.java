package basic.week5.boj_14503;

import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int firstR = Integer.parseInt(st.nextToken());
        int firstC = Integer.parseInt(st.nextToken());
        int firstD = Integer.parseInt(st.nextToken());

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                int i = Integer.parseInt(st.nextToken());
                map[r][c] = i;
            }
        }

        clean(firstR, firstC, firstD);
        System.out.print(count);
    }

    private static void clean(int r, int c, int d) {
        while(true) {
            if(map[r][c] == 0) {
                map[r][c] = 2;
                count++;
            }

            boolean found = false;

            for(int i = 0; i < 4; i++) {
                int nr = r + dy[i];
                int nc = c + dx[i];

                if(nr >=0 && nc >= 0 && nr < N && nc < M) {
                    if(map[nr][nc] == 0) {
                        found = true;
                        break;
                    }
                }
            }

            if(found) {
                d--;
                if(d < 0) d = 3;
                int nr = r + dy[d];
                int nc = c + dx[d];

                if(nr >=0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
                    r = nr;
                    c = nc;
                }
            }
            else {
                int br = r - dy[d];
                int bc = c - dx[d];

                if(br >=0 && bc >= 0 && br < N && bc < M && map[br][bc] != 1) {
                    r = br;
                    c = bc;
                } else break;
            }
        }
    }
}
