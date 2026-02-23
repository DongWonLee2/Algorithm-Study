package basic.week6.boj_14890;

import java.util.*;
import java.io.*;

public class Improve {
    static int[][] map;
    static int N, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            // 행 검사
            if(canBuildRoad(map[i])) count ++;

            // 열 int 배열로 생성
            int[] col = new int[N];
            for(int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }

            // 열 검사
            if(canBuildRoad(col)) count++;
        }

        System.out.print(count);
    }

    private static boolean canBuildRoad(int[] road) {
        boolean[] used = new boolean[N];

        for(int i = 0; i < N - 1; i++) {
            if(road[i] == road[i + 1]) continue;

            int diff = road[i] - road[i + 1];

            if(Math.abs(diff) > 1) return false;

            // 올라가는 경사로
            if(diff == -1) {
                for(int j = 0; j < L; j++) {
                    if(i - j < 0 || road[i] != road[i - j] || used[i - j]) return false;
                    used[i - j] = true;
                }
            }
            // 내려가는 경사로
            else if(diff == 1) {
                for(int j = 1; j <= L; j++) {
                    if(i + j >= N || road[i + 1] != road[i + j] || used[i + j]) return false;
                    used[i + j] = true;
                }
            }
        }

        return true;
    }
}
