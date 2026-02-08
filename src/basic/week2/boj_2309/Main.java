package basic.week2.boj_2309;

import java.util.*;
import java.io.*;

public class Main {

    static int[] height = new int[9];
    static int[] result = new int[7];
    static boolean found = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            height[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(height);

        DFS(0, 0, 0);
    }
    private static void DFS(int idx, int count, int sum) {
        if(found) return;

        if(count == 7) {
            if(sum == 100) {
                for(int h : result) {
                    System.out.println(h);
                }
                found = true;
            }
            return;
        }

        if(idx == 9) return;

        for(int i = idx; i < 9; i++) {
            result[count] = height[i];
            DFS(i + 1, count + 1, sum + height[i]);
        }
    }
}
