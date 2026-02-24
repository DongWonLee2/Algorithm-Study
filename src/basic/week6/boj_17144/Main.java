package basic.week6.boj_17144;

import java.io.*;
import java.util.*;

public class Main {
    static int R, C, T;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int[] machine = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        int a = 0;
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == -1) {
                    machine[a] = i;
                    a++;
                }
                map[i][j] = input;
            }
        }

        for(int t = 0; t < T; t++) {
            diffusion();
            airMove(t);
        }

        int count = 0;
        for(int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0) count += map[i][j];
            }
        }

        System.out.print(count);
    }

    private static void diffusion() {
        int[][] tempMap = new int[R][C];

        for(int i : machine) {
            tempMap[i][0] = -1;
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                int currDust = map[i][j];

                if(currDust == -1 || currDust == 0) continue;
                int moveDust = currDust / 5;
                int count = 0;
                for(int k = 0; k < 4; k++) {
                    int nextR = i + dr[k];
                    int nextC = j + dc[k];
                    if(nextR >= R || nextR < 0 || nextC >= C || nextC < 0) continue;
                    if(map[nextR][nextC] == -1) continue;
                    tempMap[nextR][nextC] += moveDust;
                    count++;
                }
                tempMap[i][j] += currDust - moveDust * count;
            }
        }

        for(int i = 0; i < R; i++) {
            map[i] = tempMap[i];
        }
    }

    private static void airMove(int t) {
        // 위쪽 공기청정기 (반시계 방향)
        int top = machine[0];
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) map[0][i] = map[0][i + 1];
        // 위로 당기기
        for (int i = 0; i < top; i++) map[i][C - 1] = map[i + 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) map[top][i] = map[top][i - 1];
        map[top][1] = 0; // 공기청정기에서 나가는 바람은 먼지가 0

        // 아래쪽 공기청정기 (시계 방향)
        int bottom = machine[1];
        // 위로 당기기
        for (int i = bottom + 1; i < R - 1; i++) map[i][0] = map[i + 1][0];
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) map[R - 1][i] = map[R - 1][i + 1];
        // 아래로 당기기
        for (int i = R - 1; i > bottom; i--) map[i][C - 1] = map[i - 1][C - 1];
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) map[bottom][i] = map[bottom][i - 1];
        map[bottom][1] = 0;
    }
}
