package week02.boj_1992;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        solve(0, 0, n);
        System.out.print(sb);
    }

    private static void solve(int y, int x, int size) {
        if(isAllSame(y, x, size)) {
            sb.append(map[y][x]);
            return;
        }

        sb.append("(");
        int newSize = size/2;
        solve(y, x, newSize);
        solve(y, x + newSize, newSize);
        solve(y + newSize, x, newSize);
        solve(y + newSize, x + newSize, newSize);
        sb.append(")");
    }

    private static boolean isAllSame(int y, int x, int size) {
        int element = map[y][x];
        for(int i = y; i < y + size; i++) {
            for(int j = x; j < x + size; j++) {
                if(element != map[i][j]) return false;
            }
        }
        return true;
    }
}
