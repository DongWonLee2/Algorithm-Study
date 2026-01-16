package week02.study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DirectionVector {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map = new int[3][3];
    static int[][] visited =  new int[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0 ,0);

    }

    private static void go(int y, int x) {
        visited[y][x] = 1;
        System.out.printf("(%d, %d)\n", y, x);

        for(int i = 0; i < 4; i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || ny >= 3 || nx < 0 || nx >= 3) continue; // underflow, overflow 방지
            if(map[ny][nx] == 1 && visited[ny][nx] == 0) {
                go(ny, nx);
            }
        }
        return;
    }
}
