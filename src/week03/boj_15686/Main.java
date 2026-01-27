package week03.boj_15686;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int y;
        int x;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int N, M, delChicStore, chicStore;
    static int[][] map;
    static List<Point> chicPoint;
    static List<Point> houseList;
    static int resultDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        chicPoint = new ArrayList<>();
        houseList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if(input == 2) {
                    chicStore++;
                    chicPoint.add(new Point(i, j));
                }
                if(input == 1) {
                    houseList.add(new Point(i, j));
                }
                map[i][j] = input;
            }
        }
        delChicStore = chicStore - M;

        if (delChicStore == 0) {
            calDist();
        } else {
            delete(0, 0);
        }

        System.out.print(resultDist);

    }

    private static void delete(int idx, int count) {
        if(count == delChicStore){
            calDist();
            return;
        }

        for(int i = idx; i < chicStore; i++) {
            map[chicPoint.get(i).y][chicPoint.get(i).x] = 0;
            delete(i + 1, count + 1);
            map[chicPoint.get(i).y][chicPoint.get(i).x] = 2;
        }

    }

    private static void calDist() {
        int totalDist = 0;

        for (int i = 0; i < houseList.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] == 2) {
                        int yDist = Math.abs(houseList.get(i).y - j);
                        int xDist = Math.abs(houseList.get(i).x - k);
                        int currDist = yDist + xDist;

                        minDist = Math.min(minDist, currDist);
                    }
                }
            }
            totalDist += minDist;
        }

        resultDist = Math.min(totalDist, resultDist);
    }
}
