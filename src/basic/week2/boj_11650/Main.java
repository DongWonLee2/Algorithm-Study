package basic.week2.boj_11650;

import java.util.*;
import java.io.*;

public class Main {

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Point> pList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            pList.add(new Point(x, y));
        }

        pList.sort(Comparator
                .comparingInt((Point p) -> p.x)
                .thenComparingInt(p -> p.y));

        StringBuilder sb = new StringBuilder();
        for (Point p : pList) {
            sb.append(p.x).append(" ").append(p.y).append("\n");
        }

        System.out.print(sb);
    }
}
