package week03.boj_4179;

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

    static int R, C;
    static int[][] map;
    static int[][] jVisited, fVisited;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Point ji;
    static ArrayList<Point> fires = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        jVisited = new int[R][C];
        fVisited = new int[R][C];

        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                char c = input.charAt(j);
                if(c == '#') {
                    continue;
                }
                else if(c == 'J') {
                    map[i][j] = 2;
                    ji = new Point(i, j);
                }
                else if(c == 'F') {
                    map[i][j] = 3;
                    fires.add(new Point(i, j));
                }
                else {
                    map[i][j] = 1;
                }
            }
        }

        int result = BFS(ji);
        if(result == 0) {
            System.out.print("IMPOSSIBLE");
        } else {
            System.out.print(result);
        }
    }

    private static int BFS(Point p) {
        Queue<Point> q = new ArrayDeque<>();
        jVisited[p.y][p.x] = 1;
        q.offer(p);

        while(!q.isEmpty()) {
            int size = q.size();
            goFire(fires);

            for(int i = 0; i < size; i++) {
                Point curr = q.poll();
                for(int j = 0; j < 4; j++) {
                    int ny = curr.y + dy[j];
                    int nx = curr.x + dx[j];

                    if(ny < 0 || ny >= R || nx < 0 || nx >= C) {
                        return jVisited[curr.y][curr.x];
                    }
                    if(jVisited[ny][nx] == 0 && map[ny][nx] == 1) {
                        q.offer(new Point(ny, nx));
                        jVisited[ny][nx] = jVisited[curr.y][curr.x] + 1;
                    }
                }
            }
        }
        return 0;
    }

    private static void goFire(ArrayList<Point> fires) {
        ArrayList<Point> newFires = new ArrayList<>();
        for(Point p : fires) {
            fVisited[p.y][p.x] = 1;
            for(int i = 0; i < 4; i++) {
                int ny = p.y + dy[i];
                int nx = p.x + dx[i];

                if(ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if(fVisited[ny][nx] == 0 && map[ny][nx] == 1) {
                    map[ny][nx] = 3;
                    fVisited[ny][nx] = 1;
                    newFires.add(new Point(ny, nx));
                }
            }

        }
        fires.clear();
        fires.addAll(newFires);
    }
}
