package basic.week7.boj_1697;

import java.util.*;

public class Main {
    int k;
    int[] dist;
    public static void main(String[] args) {
        Main main = new Main();
        main.solve();
    }

    private void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();
        dist = new int[100001];

        BFS(n);
        System.out.print(dist[k]);
    }

    private void BFS(int n) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(curr == k) {
                break;
            }
            if(curr + 1 <= 100000 && dist[curr + 1] == 0) {
                dist[curr + 1] = dist[curr] + 1;
                q.offer(curr + 1);
            }

            if(curr - 1 >= 0 && dist[curr - 1] == 0) {
                dist[curr - 1] = dist[curr] + 1;
                q.offer(curr - 1);
            }

            if(curr * 2 <= 100000 && dist[curr * 2] == 0) {
                dist[curr * 2] = dist[curr] + 1;
                q.offer(curr * 2);
            }
        }
    }
}
