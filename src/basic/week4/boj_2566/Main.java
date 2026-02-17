package basic.week4.boj_2566;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] matrix = new int[9][9];

        int max = 0;
        int row = 0, column = 0;
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 9; j++) {
                int num = Integer.parseInt(st.nextToken());
                matrix[i][j] = num;
                max = Math.max(max, num);
                if(max == num) {
                    row = i + 1;
                    column = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
