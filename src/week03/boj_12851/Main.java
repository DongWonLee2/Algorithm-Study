package week03.boj_12851;

import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];
    static int min = 100000;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        BFS(N);

        System.out.println(min);
        System.out.println(count);
    }

    private static void BFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        visited[n] = 1;

        while(!q.isEmpty()){
            int currN = q.poll();

            if (visited[currN] - 1 > min) continue;

            if(currN == K) {
                if(min == visited[currN] - 1) {
                    count++;
                }
                else {
                    min = Math.min(min, visited[currN] - 1);
                    count = 1;
                }
                continue;
            }

            int[] nextNodes = {currN - 1, currN + 1, currN * 2};
            for (int next : nextNodes) {
                if (next < 0 || next > 100000) continue;

                // 미방문이거나 이미 방문했더라도 같은 시간에 도착하는 경우 허용
                if (visited[next] == 0 || visited[next] == visited[currN] + 1) {
                    visited[next] = visited[currN] + 1;
                    q.offer(next);
                }
            }
        }
    }

}
