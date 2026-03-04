package basic.week7.boj_15686;

import java.util.*;
import java.io.*;

public class Main {
    int n, m;
    int min = 10000000;
    List<int []> chickens;
    List<int []> houses;
    boolean[] visited;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        chickens = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                int n = Integer.parseInt(st.nextToken());
                if(n == 1) houses.add(new int[] {i, j});
                if(n == 2) chickens.add(new int[] {i, j});
            }
        }

        visited = new boolean[chickens.size()];
        solve(0, 0);
        System.out.print(min);
    }

    private void solve(int idx, int count) {
        if(count == m) {
            min = Math.min(min, calc());
            return;
        }

        for(int i = idx; i < chickens.size(); i++) {
            visited[i] = true;
            solve(i + 1, count + 1);
            visited[i] = false;
        }
    }

    private int calc() {
        int total = 0;
        for(int[] h : houses) {
            int dist = 1000000;
            for(int i = 0; i < chickens.size(); i++) {
                if(visited[i]) {
                    int d = Math.abs(h[0] - chickens.get(i)[0])
                            + Math.abs(h[1] - chickens.get(i)[1]);
                    dist = Math.min(dist, d);
                }
            }
            total += dist;
            if(total >= min) return total;
        }
        return total;
    }
}
