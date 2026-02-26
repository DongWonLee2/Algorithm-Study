package basic.week6.boj_15651;

import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if(count == M) {
            for(int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            result[count] = i;
            solve(count + 1);
        }
    }
}
