package basic.week3.boj_1966;

import java.io.*;
import java.util.*;

public class Main {

    static class Doc {
        int printIdx, value;

        Doc(int printIdx, int value) {
            this.printIdx = printIdx;
            this.value = value;
        }
    }
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            Queue<Doc> queue = new ArrayDeque<>();
            List<Integer> vList = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int v = Integer.parseInt(st.nextToken());
                vList.add(v);
                queue.offer(new Doc(j, v));
            }
            vList.sort(Comparator.reverseOrder());
            solve(queue, vList, idx);
        }

        System.out.println(sb);
    }

    private static void solve(Queue<Doc> q, List<Integer> l, int i) {
        int seq = 1;
        int maxIdx = 0;
        while(!q.isEmpty()) {
            Doc currD = q.poll();
            int currMax = l.get(maxIdx);

            if(currMax > currD.value) {
                q.offer(currD);
                continue;
            }

            if(currD.printIdx == i) {
                sb.append(seq).append("\n");
                break;
            }

            maxIdx++;
            seq++;
        }
        
    }
}
