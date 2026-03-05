package basic.week7.boj_14891;

import java.util.*;
import java.io.*;

public class Main {
    int[][] gears;
    List<int []> info;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gears = new int[4][8];
        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0; j < 8; j++) {
                gears[i][j] = input.charAt(j) - '0';
            }
        }

        info = new ArrayList<>();
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearN = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            info.add(new int[] {gearN - 1, dir});
        }

        solve();
        int result = calc();
        System.out.print(result);
    }

    private void solve() {
        for(int[] in : info) {
            int gearN = in[0];
            int dir = in[1];
            List<int []> turns = new ArrayList<>();
            turns.add(new int[] {gearN, dir});

            if(gearN == 0) {
                // 오른쪽
                int currDir = dir;
                for(int i = gearN + 1; i < 4; i++) {
                    int currGR = gears[i - 1][2];
                    int thisGL = gears[i][6];
                    if(currGR != thisGL) {
                        currDir = -currDir;
                        turns.add(new int[] {i, currDir});
                    }
                    else {
                        break;
                    }
                }
            }
            else if(gearN == 3) {
                // 왼쪽
                int currDir = dir;
                for(int i = gearN - 1; i >= 0; i--) {
                    int currGR = gears[i + 1][6];
                    int thisGL = gears[i][2];
                    if(currGR != thisGL) {
                        currDir = -currDir;
                        turns.add(new int[] {i, currDir});
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                // 오른쪽
                int currDir = dir;
                for(int i = gearN + 1; i < 4; i++) {
                    int currGR = gears[i - 1][2];
                    int thisGL = gears[i][6];
                    if(currGR != thisGL) {
                        currDir = -currDir;
                        turns.add(new int[] {i, currDir});
                    }
                    else {
                        break;
                    }
                }
                // 왼쪽
                currDir = dir;
                for(int i = gearN - 1; i >= 0; i--) {
                    int currGR = gears[i + 1][6];
                    int thisGL = gears[i][2];
                    if(currGR != thisGL) {
                        currDir = -currDir;
                        turns.add(new int[] {i, currDir});
                    }
                    else {
                        break;
                    }
                }
            }

            for(int[] t : turns) {
                turn(t[0], t[1]);
            }
        }
    }

    private void turn(int gearN, int dir) {
        // dir == 1 시계
        if(dir == 1) {
            int temp = gears[gearN][7]; // 마지막 톱니
            for(int i = 7; i > 0; i--) {
                gears[gearN][i] = gears[gearN][i - 1];
            }
            gears[gearN][0] = temp;
        }
        // dir == -1 시계 반대
        else {
            int temp = gears[gearN][0]; // 첫번째 톱니
            for(int i = 0; i < 7; i++) {
                gears[gearN][i] = gears[gearN][i + 1];
            }
            gears[gearN][7] = temp;
        }
    }

    private int calc() {
        int sum = 0;
        for(int i = 0; i < 4; i++) {
            if(gears[i][0] == 1) {
                if(i == 0) sum += 1;
                else if(i == 1) sum += 2;
                else if(i == 2) sum += 4;
                else if(i == 3) sum += 8;
            }
        }

        return sum;
    }
}
