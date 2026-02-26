package basic.week6.boj_15649;

import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int N, M;
    static int[] result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        result = new int[M];

        visited = new boolean[N + 1];

        solve(0);
        System.out.print(sb);
    }

    private static void solve(int count) {
        if(count == M) {
            for(int val : result) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[count] = i;

                solve(count + 1);

                visited[i] = false;
            }
        }
    }
}
