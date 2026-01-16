package week01.boj_11655;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s != null) {
            System.out.println(solve(s));
        }
    }

    private static String solve(String input) {
        StringBuilder sb = new StringBuilder();

        for (char a : input.toCharArray()) {
            if (Character.isUpperCase(a)) {
                // 대문자 처리: 'A'를 빼서 0~25로 만든 뒤 13을 더하고 26으로 나눈 나머지를 구함
                char shifted = (char) ((a - 'A' + 13) % 26 + 'A');
                sb.append(shifted);
            }
            else if (Character.isLowerCase(a)) {
                // 소문자 처리: 'a'를 빼서 0~25로 만든 뒤 13을 더하고 26으로 나눈 나머지를 구함
                char shifted = (char) ((a - 'a' + 13) % 26 + 'a');
                sb.append(shifted);
            }
            else {
                sb.append(a);
            }
        }
        // 관심사의 분리("문제를 푸는 로직(Solve)"과 "결과를 출력하는 로직(I/O)")
        // toString()을 호출하는 것은 "이제 문자열 조립이 끝났으니, 변하지 않는 최종 결과물로 확정 짓겠다"라는 선언.
        // StringBuilder 객체 자체를 반환하면, 이 객체를 받는 쪽에서 실수로 내용을 더 수정해버릴 위험이 있음.
        return sb.toString();
    }
}