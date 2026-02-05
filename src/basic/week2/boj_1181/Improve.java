package basic.week2.boj_1181;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> wordSet = new HashSet<>();

        // ArrayList.contains()는 리스트의 처음부터 끝까지 다 뒤져보는 O(N) 연산
        // 중복을 허용하지 않는 HashSet -> 중복 체크 O(1)
        for(int i = 0; i < N; i++) {
            wordSet.add(br.readLine());
        }

        List<String> words = new ArrayList<>(wordSet);

        words.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(s -> s));

        StringBuilder sb = new StringBuilder();
        for(String s : words) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}
