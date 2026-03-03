package basic.week6.boj_2606;

import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] comNet;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        comNet = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            comNet[i] = new ArrayList<>();
        }
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            comNet[from].add(to);
            comNet[to].add(from);
        }

        dfs(1);

        System.out.print(count);
    }

    private static void dfs(int n) {
        visited[n] = true;

        for(int next : comNet[n]) {
            if(!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
