package week01.boj_9375;

import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static HashMap<String, Integer> wearing;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i < tc; i++) {
            input();
            sb.append(solve()).append("\n");
        }

        System.out.print(sb);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        wearing = new HashMap<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.hasMoreTokens()) st.nextToken(); // 첫 번째 스킵
            if (st.hasMoreTokens()) {
                String type = st.nextToken(); // 두 번째 저장
                wearing.put(type, wearing.getOrDefault(type, 0) + 1); // 키의 값을 가져오되, 없으면 0을 반환
            }
        }
    }

    private static int solve() {
        int r = 1;
        for(int count : wearing.values()) {
            r *= (count + 1);
        }
        return r - 1;
    }
}
