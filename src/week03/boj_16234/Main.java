package week03.boj_16234;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, L, R;
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<Point> countries = new ArrayList<>();
    static int countDate = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true) {
            boolean moved = false;
            for(int i = 0; i < N; i++) {
                Arrays.fill(visited[i], 0);
            }
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j] == 0) {
                        countries.clear();
                        DFS(i, j);
                        if(countries.size() > 1) {
                            calc();
                            moved = true;
                        }
                    }
                }
            }
            if(!moved) break;
            countDate++;
        }

        System.out.print(countDate);
    }

    private static void DFS(int y, int x) {
        visited[y][x] = 1;
        countries.add(new Point(y, x));

        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if(visited[ny][nx] == 0) {
                int diff = Math.abs(map[ny][nx] - map[y][x]);
                if(diff >= L && diff <= R) {
                    DFS(ny, nx);
                }
            }
        }
    }

    private static void calc() {
        int sumPeople = 0;
        int countCty = countries.size();
        for(int i = 0; i < countCty; i++) {
            Point currP = countries.get(i);
            sumPeople += map[currP.y][currP.x];
        }
        int divPeople = sumPeople / countCty;

        for(int i = 0; i < countCty; i++) {
            Point currP = countries.get(i);
            map[currP.y][currP.x] = divPeople;
        }
    }
}