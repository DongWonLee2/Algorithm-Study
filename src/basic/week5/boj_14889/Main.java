package basic.week5.boj_14889;

import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] stats;
    static int result = 2000;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        stats = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                stats[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0, 0);

        System.out.print(result);
    }

    private static void combi(int idx, int count) {
        if(count == N / 2) {
            calc();
            return;
        }

        if(idx == N) {
            return;
        }

        for(int i = idx; i < N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    private static void calc() {
        int startTeam = 0;
        int linkTeam = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(visited[i] && visited[j]) {
                    startTeam += stats[i][j] + stats[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    linkTeam += stats[i][j] + stats[j][i];
                }
            }
        }
        result = Math.min(result, Math.abs(startTeam - linkTeam));
    }
}
