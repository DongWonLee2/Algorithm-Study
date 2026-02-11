package basic.week3.boj_1764;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> names = new HashSet<>();
        for(int i = 0; i < N; i++) {
            names.add(br.readLine());
        }

        List<String> result = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < M; i++) {
            String name = br.readLine();
            if(names.contains(name)) {
                result.add(name);
                count++;
            }
        }
        result.sort(Comparator.naturalOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n");
        for(String s : result) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}
