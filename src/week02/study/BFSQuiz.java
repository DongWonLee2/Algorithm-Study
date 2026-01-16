package week02.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFSQuiz {

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};
    static int[][] map;
    static int[][] visitedDFS;
    static ArrayList<Point>[][] adj;
    static int[][] visitedBFS;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int sy = Integer.parseInt(st.nextToken());
        int sx = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int ay = Integer.parseInt(st.nextToken());
        int ax = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visitedDFS = new int[N][M];
        adj = new ArrayList[N][M];
        visitedBFS = new int[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                adj[i][j] = new ArrayList<>();
            }
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 0);
        BFS(sy, sx);
        System.out.println(visitedBFS[ay][ax]);
    }
    public static void DFS(int y, int x){
        visitedDFS[y][x] = 1;

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if(map[ny][nx] == 1 && visitedDFS[ny][nx] == 0){
                adj[y][x].add(new Point(ny, nx));
                DFS(ny, nx);
            }
        }
    }

    public static void BFS(int y, int x){
        Queue<Point> q = new ArrayDeque<>();
        visitedBFS[y][x] = 1;
        q.offer(new Point(y, x));
        while(!q.isEmpty()){
            Point curr = q.poll();
            for(Point next : adj[curr.y][curr.x]){
                if(visitedBFS[next.y][next.x] != 0) continue;
                visitedBFS[next.y][next.x] = visitedBFS[curr.y][curr.x] + 1;
                q.offer(next);
            }
        }
    }
}
