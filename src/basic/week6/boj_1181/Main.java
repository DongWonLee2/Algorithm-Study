package basic.week6.boj_1181;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        String[] words = new String[N];
        for(int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }

        Arrays.sort(words, Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder())
        );

        StringBuilder sb = new StringBuilder();
        sb.append(words[0]).append("\n");
        for (int i = 1; i < N; i++) {
            // 중복 제거
            if (!words[i].equals(words[i - 1])) {
                sb.append(words[i]).append("\n");
            }
        }

        System.out.print(sb);
    }
}


/*

 */