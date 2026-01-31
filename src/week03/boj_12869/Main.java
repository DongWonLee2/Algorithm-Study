package week03.boj_12869;

import java.util.*;
import java.io.*;

public class Main {

    static class State {
        int s1, s2, s3;
        int count;

        State(int s1, int s2, int s3, int count) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.count = count;
        }
    }

    static int[][] attacks = {
            {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}
    };
    static int[][][] hp = new int[61][61][61];
    static int N;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] scv = new int[N];
        for(int i = 0; i < N; i++) {
            scv[i] = sc.nextInt();
        }

        System.out.print(BFS(scv));

    }
    private static int BFS(int[] scv) {
        Queue<State> q = new ArrayDeque<>();

        int s1 = scv[0];
        int s2 = (N >= 2) ? scv[1] : 0;
        int s3 = (N >= 3) ? scv[2] : 0;

        q.offer(new State(s1, s2, s3, 0));
        hp[s1][s2][s3] = 1;

        while(!q.isEmpty()) {
            State curr = q.poll();
            if(curr.s1 == 0 && curr.s2 == 0 && curr.s3 == 0) {
                return curr.count;
            }

            for(int[] attack: attacks) {
                int ns1 = Math.max(0, curr.s1 - attack[0]);
                int ns2 = Math.max(0, curr.s2 - attack[1]);
                int ns3 = Math.max(0, curr.s3 - attack[2]);

                if(hp[ns1][ns2][ns3] == 0) {
                    hp[ns1][ns2][ns3] = 1;
                    q.offer(new State(ns1, ns2, ns3, curr.count + 1));
                }
            }
        }
        return -1;
    }
}
