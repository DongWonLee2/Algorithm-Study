package week02.boj_1325;

import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] comRelationship;
    static int[] visited;

    public static void main(String[] agrs) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        comRelationship = new ArrayList[N + 1];
        visited = new int[N + 1];

        for(int i = 0; i < N + 1; i++) {
            comRelationship[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            comRelationship[B].add(A);
        }

        int maxCount = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i < N + 1; i++) {
            if(comRelationship[i].isEmpty()) continue;
            int currCount = BFS(i);
            if(currCount > maxCount) {
                maxCount = currCount;
                result.clear();
                result.add(i);
            }
            else if(currCount == maxCount) {
                result.add(i);
            }
        }
        result.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++) {
            sb.append(result.get(i)).append(" ");
        }
        System.out.print(sb);
        // System.out.print(Arrays.toString(comRelationship));
    }

    private static int BFS(int comNum) {
        Queue<Integer> q = new ArrayDeque<>();
        int count = 0;
        Arrays.fill(visited, 0); // 값만 초기화하여 재사용해 메모리 아끼기
        visited[comNum] = 1;
        q.offer(comNum);
        while(!q.isEmpty()) {
            int currComNum = q.poll();
            for(int nextCom : comRelationship[currComNum]) {
                if(visited[nextCom] == 0) {
                    q.offer(nextCom);
                    visited[nextCom] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
