package basic.week6.boj_14891;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] gear;
    static int[] dir;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        gear = new int[4][8];
        for(int i = 0; i < 4; i++) {
            String input = br.readLine();
            for(int j = 0; j < 8; j++) {
                gear[i][j] = input.charAt(j) - '0';
            }
        }

        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearN = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            dir = new int[4];
            checkDir(gearN, d);
            gearTurn();
        }

        int result = 0;
        if(gear[0][0] == 1) result += 1;
        if(gear[1][0] == 1) result += 2;
        if(gear[2][0] == 1) result += 4;
        if(gear[3][0] == 1) result += 8;
        System.out.print(result);
    }

    private static void checkDir(int gearN, int d) {
        dir[gearN] = d;
        for(int i = gearN - 1; i >= 0; i--) {
            if(gear[i][2] != gear[i + 1][6]) dir[i] = -dir[i+1];
            else break;
        }

        for(int i = gearN; i < 3; i++) {
            if(gear[i][2] != gear[i + 1][6]) dir[i + 1] = -dir[i];
            else break;
        }
    }

    private static void gearTurn() {
        for(int i = 0; i < 4; i++) {
            if(dir[i] == 0) continue;

            if(dir[i] == 1) {
                int temp = gear[i][7];
                for(int j = 7; j > 0; j--) {
                    gear[i][j] = gear[i][j - 1];
                }
                gear[i][0] = temp;
            }
            else {
                int temp = gear[i][0];
                for(int j = 0; j < 7; j++) {
                    gear[i][j] = gear[i][j + 1];
                }
                gear[i][7] = temp;
            }
        }
    }

}
