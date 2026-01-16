package week01.boj_1213;

import java.util.*;
import java.io.*;

public class Another {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int[] cnt = new int[26]; // A-Z 빈도 저장
        for (char c : s.toCharArray()) {
            cnt[c - 'A']++;
        }

        int flag = 0;
        char mid = 0;
        StringBuilder head = new StringBuilder();

        // 사전순으로 앞서야 하므로 A부터 Z까지 확인
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                // 홀수 개인 문자가 있다면
                if (cnt[i] % 2 != 0) {
                    mid = (char) (i + 'A');
                    flag++;
                    cnt[i]--; // 하나는 가운데 둘 것이므로 제외
                }

                // 이미 홀수가 2개 이상이면 팰린드롬 불가능
                if (flag == 2) break;

                // 절반만 head에 붙임
                for (int j = 0; j < cnt[i] / 2; j++) {
                    head.append((char) (i + 'A'));
                }
            }
        }

        if (flag >= 2) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            String result = head.toString();
            String tail = head.reverse().toString(); // head를 뒤집으면 tail이 됨

            // 결과 조합: [앞부분] + [가운데(있다면)] + [뒷부분]
            if (mid != 0) {
                System.out.println(result + mid + tail);
            } else {
                System.out.println(result + tail);
            }
        }
    }
}