package basic.week6.boj_15650;

import java.util.*;

public class Main {
    static int N, M;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        result = new int[M];
        visited = new boolean[N + 1];

        solve(0, 0);

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

        for(int i = 1; i <= N; i++) {
            if(!visited[i] && i > last) {
                visited[i] = true;
                result[count] = i;
                solve(count + 1, i);
                visited[i] = false;
            }
        }
    }
}
