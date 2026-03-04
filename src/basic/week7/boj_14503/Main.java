package basic.week7.boj_14503;

import java.util.*;
import java.io.*;

public class Main {
    int n, m;
    int[] robot;
    int[][] room;
    boolean canMove = true;
    int[] dr = {-1, 0, 1, 0};
    int[] dc = {0, 1, 0, -1};
    int count = 0;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        robot = new int[3];
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        robot[2] = Integer.parseInt(st.nextToken());

        room = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken()); // 0: 청소 X, 1: 벽
            }
        }

        solve();
        System.out.print(count);
    }

    private void solve() {
        while(canMove) {
            int currR = robot[0];
            int currC = robot[1];
            int currD = robot[2];

            if(room[currR][currC] == 0) {
                count++;
                room[currR][currC] = 2; // 2: 청소 O
            }

            int nextD = dirCheck(currR, currC, currD);
            if(nextD >= 0 && nextD <= 3) {
                move(currR, currC, nextD);
            }
            else {
                if(!backMove(currR, currC, currD)){
                    break;
                }
            }
        }
    }

    private int dirCheck(int r, int c, int d) {
        int nextD = d;
        for(int i = 0; i < 4; i++) {
            nextD = (nextD + 3) % 4;
            int nextR = r + dr[nextD];
            int nextC = c + dc[nextD];
            if(room[nextR][nextC] == 0) {
                return nextD;
            }
        }

        return -1;
    }

    private void move(int r, int c, int d) {
        robot[0] = r + dr[d];
        robot[1] = c + dc[d];
        robot[2] = d;
    }

    private boolean backMove(int r, int c, int d) {
        int nextD = (d + 2) % 4;
        int nextR = r + dr[nextD];
        int nextC = c + dc[nextD];
        if(room[nextR][nextC] != 1) {
            robot[0] = nextR;
            robot[1] = nextC;
            robot[2] = d;
            return true;
        }
        else {
            return false;
        }
    }
}
