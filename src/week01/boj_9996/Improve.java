package week01.boj_9996;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N 읽기
        int n = Integer.parseInt(br.readLine());
        // 패턴 읽기
        String pattern = br.readLine();

        // 별표(*) 위치 찾기
        int idx = pattern.indexOf('*');
        // 접두사(Prefix)와 접미사(Suffix) 분리
        String front = pattern.substring(0, idx);
        String back = pattern.substring(idx + 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String fileName = br.readLine();

            if(isValid(fileName, front, back)) {
                sb.append("DA\n");
            } else {
                sb.append("NE\n");
            }
        }
        // 한 번에 출력 (출력 최적화)
        System.out.print(sb.toString());
    }

    private static boolean isValid(String file, String front, String back) {
        // [핵심] 파일 길이가 패턴의 앞뒤 길이 합보다 작으면 절대 매칭될 수 없음
        if (file.length() < front.length() + back.length()) {
            return false;
        }

        // startsWith와 endsWith로 깔끔하게 비교
        return file.startsWith(front) && file.endsWith(back);
    }
}

