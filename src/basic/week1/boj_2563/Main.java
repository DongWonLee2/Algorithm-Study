package basic.week1.boj_2563;

import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            for(int y = b; y < b + 10; y++) {
                for(int x = a; x < a + 10; x++) {
                    if(paper[y][x] == 0) {
                        paper[y][x] = 1;
                        count++;
                    }
                }
            }
        }

        System.out.print(count);
    }
}
