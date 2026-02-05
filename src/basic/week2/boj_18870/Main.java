package basic.week2.boj_18870;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] xPoints = new int[N];
        int[] xSort = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int a = Integer.parseInt(st.nextToken());
            xPoints[i] = a;
            xSort[i] = a;
        }

        Arrays.sort(xSort);

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i : xSort) {
            if(!map.containsKey(i)) {
                map.put(i, index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : xPoints) {
            sb.append(map.get(i)).append(" ");
        }

        System.out.print(sb);
    }
}
