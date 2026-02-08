package basic.week2.boj_14501;

import java.util.*;
import java.io.*;

public class Main {

    static int[][] days;
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        days = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i][0] = Integer.parseInt(st.nextToken());
            days[i][1] = Integer.parseInt(st.nextToken());
        }

        DFS(0, 0);
        System.out.print(max);
    }

    private static void DFS(int idx, int sum) {
        max = Math.max(max, sum);

        if(idx >= N) {
            return;
        }

        for(int i = idx; i < N; i++) {
            int nextIdx = i + days[i][0];

            if(nextIdx <= N) {
                int salary = sum + days[i][1];
                DFS(nextIdx, salary);
            }
        }
    }

    private static void DFS2(int idx, int sum) {
        // 베이스 케이스: 퇴사 날짜에 딱 도달했을 때
        if (idx == N) {
            max = Math.max(max, sum);
            return;
        }

        // 퇴사 날짜를 넘어버리는 경우 (상담을 못 끝냄)
        if (idx > N) {
            // 이때는 이전 단계의 sum을 max와 비교할 수 없으므로 그냥 종료 (안전장치)
            return;
        }

        // 선택 1: 오늘 상담을 한다 (단, 퇴사 전에 끝날 수 있을 때만)
        if (idx + days[idx][0] <= N) {
            DFS(idx + days[idx][0], sum + days[idx][1]);
        }

        // 선택 2: 오늘 상담은 패스한다
        DFS(idx + 1, sum);
    }
}
