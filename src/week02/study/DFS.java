package week02.study;

import java.util.ArrayList;

public class DFS {
    static ArrayList<Integer>[] adj = new ArrayList[6];
    static int[] visited = new int[6];
    public static void main(String[] args) {

        for(int i = 0; i < 6; i++){
            adj[i] = new ArrayList<>();
        }

        adj[1].add(2); adj[1].add(3);
        adj[2].add(1); adj[2].add(4); adj[2].add(5);
        adj[3].add(1);
        adj[4].add(2);
        adj[5].add(2);

        DFS2(1);
    }

    public static void DFS(int start){
        visited[start] = 1;
        System.out.printf("%d \n", start);
        for(int i : adj[start]){
            if(visited[i] == 0){ // 기저 사례
                DFS(i);
            }
        }
        System.out.printf("%d %s\n", start, "종료");
        // 암시적 return
    }

    public static void DFS2(int start){
        if(visited[start] == 1) return;
        visited[start] = 1;
        System.out.printf("%d \n", start);
        for(int i : adj[start]){
            DFS2(i);
        }
        System.out.printf("%d %s\n", start, "종료");
    }
}
