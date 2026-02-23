package basic.week6.boj_14890;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N, L;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            solveRow(i);
        }

        for(int i = 0; i < N; i++) {
            solveCol(i);
        }

        System.out.print(count);
    }

    private static void solveRow(int r){
        boolean isRoad = true;
        boolean[] used = new boolean[N];
        int lastH = map[r][0];

        for(int i = 1; i < N; i++) {
            int currH = map[r][i];
            if(currH == lastH) continue;
            else {
                int diffH = Math.abs(currH - lastH);
                if(currH - lastH > 0 && diffH == 1) {
                    if(i - L >= 0  && checkRowUp(r, i, lastH, used)) {
                        lastH = currH;
                        continue;
                    }
                    else {
                        isRoad = false;
                        break;
                    }
                }
                else if(currH - lastH < 0 && diffH == 1){
                    if(i + L - 1 < N && checkRowDown(r, i, currH, used)) {
                        lastH = currH;
                        continue;
                    }
                    else {
                        isRoad = false;
                        break;
                    }
                }
                else {
                    isRoad = false;
                    break;
                }
            }
        }

        if(isRoad) {
            count++;
        }
    }

    private static void solveCol(int c){
        boolean isRoad = true;
        boolean[] used = new boolean[N];
        int lastH = map[0][c];

        for(int i = 1; i < N; i++) {
            int currH = map[i][c];
            if(currH == lastH) continue;
            else {
                int diffH = Math.abs(currH - lastH);
                if(currH - lastH > 0 && diffH == 1) {
                    if(i - L >= 0  && checkColUp(i, c, lastH, used)) {
                        lastH = currH;
                        continue;
                    }
                    else {
                        isRoad = false;
                        break;
                    }
                }
                else if(currH - lastH < 0 && diffH == 1){
                    if(i + L - 1 < N && checkColDown(i, c, currH, used)) {
                        lastH = currH;
                        continue;
                    }
                    else {
                        isRoad = false;
                        break;
                    }
                }
                else {
                    isRoad = false;
                    break;
                }
            }
        }

        if(isRoad) {
            count++;
        }
    }

    private static boolean checkRowUp(int r, int c, int lastH, boolean[] used) {
        boolean can = true;
        for(int i = c - 1; i >= c - L; i--) {
            if(map[r][i] == lastH && used[i] == false) continue;
            else {
                can = false;
                break;
            }
        }
        if(can) {
            for(int i = c - 1; i >= c - L; i--) {
                used[i] = true;
            }
        }
        return can;
    }

    private static boolean checkRowDown(int r, int c, int currH, boolean[] used) {
        boolean can = true;
        for(int i = c; i <= c + L - 1; i++) {
            if(map[r][i] == currH && used[i] == false) continue;
            else {
                can = false;
                break;
            }
        }
        if(can) {
            for(int i = c; i <= c + L - 1; i++) {
                used[i] = true;
            }
        }
        return can;
    }

    private static boolean checkColUp(int r, int c, int lastH, boolean[] used) {
        boolean can = true;
        for(int i = r - 1; i >= r - L; i--) {
            if(map[i][c] == lastH && used[i] == false) continue;
            else {
                can = false;
                break;
            }
        }
        if(can) {
            for(int i = r - 1; i >= r - L; i--) {
                used[i] = true;
            }
        }
        return can;
    }

    private static boolean checkColDown(int r, int c, int currH, boolean[] used) {
        boolean can = true;
        for(int i = r; i <= r + L - 1; i++) {
            if(map[i][c] == currH && used[i] == false) continue;
            else {
                can = false;
                break;
            }
        }
        if(can) {
            for(int i = r; i <= r + L - 1; i++) {
                used[i] = true;
            }
        }
        return can;
    }
}
