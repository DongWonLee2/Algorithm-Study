package week01.boj_10988;

import java.io.*;

public class TwoPointer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int left = 0;
        int right = s.length() - 1;

        int result = 1;

        while (left < right) {
            // 양 끝의 문자가 다르면 팰린드롬이 아님
            if (s.charAt(left) != s.charAt(right)) {
                result = 0;
                break;
            }

            left++;
            right--;
        }

        System.out.println(result);
    }
}
