package week01.boj_1620;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> mapKV = new HashMap<>();
        HashMap<String, Integer> mapVK = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            mapKV.put(i, name);
            mapVK.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String input = br.readLine();
            try {
                int num = Integer.parseInt(input);
                sb.append(mapKV.get(num)).append("\n");
            } catch(NumberFormatException e) {
                String name = input;
                sb.append(mapVK.get(name)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
