package week01.boj_1620;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 1. 번호로 이름 찾기용 배열 (HashMap보다 빠름!)
        String[] numToName = new String[n + 1];
        // 2. 이름으로 번호 찾기용 맵
        HashMap<String, Integer> nameToNum = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String name = br.readLine();
            numToName[i] = name;
            nameToNum.put(name, i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            String query = br.readLine();

            // 첫 글자가 숫자인지 확인 (try-catch보다 훨씬 빠름!)
            if (Character.isDigit(query.charAt(0))) {
                int num = Integer.parseInt(query);
                sb.append(numToName[num]).append("\n");
            } else {
                sb.append(nameToNum.get(query)).append("\n");
            }
        }
        System.out.print(sb);
    }
}