package basic.week6.boj_3085;

import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static char[][] map;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        check();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                swap(i, j);
            }
        }

        System.out.print(max);
    }

    private static void swap(int r, int c) {
        if(r + 1 < n) {
            char temp = map[r][c];
            map[r][c] = map[r + 1][c];
            map[r + 1][c] = temp;
            check();
            temp = map[r][c];
            map[r][c] = map[r + 1][c];
            map[r + 1][c] = temp;
        }

        if(c + 1 < n) {
            char temp = map[r][c];
            map[r][c] = map[r][c + 1];
            map[r][c + 1] = temp;
            check();
            temp = map[r][c];
            map[r][c] = map[r][c + 1];
            map[r][c + 1] = temp;
        }
    }

    private static void check() {
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 1; j < n; j++) {
                if(i == 0 && j == 0) continue;
                if(map[i][j] == map[i][j - 1]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for(int j = 0; j < n; j++) {
            int count = 1;
            for(int i = 1; i < n; i++) {
                if(map[i][j] == map[i - 1][j]) count++;
                else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }
    }

}
