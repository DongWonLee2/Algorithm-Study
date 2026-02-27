package basic.week6.boj_15652;

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

        solve(0, 1);

        System.out.print(sb);
    }

    private static void solve(int count, int last) {
        if(count == M) {
            for(int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = last; i <= N; i++) {
            result[count] = i;
            solve(count + 1, i);
        }
    }
}
