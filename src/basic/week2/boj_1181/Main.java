package basic.week2.boj_1181;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            if(!words.contains(input)) words.add(input);
        }

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
