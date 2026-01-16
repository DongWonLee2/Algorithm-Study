package week01.boj_1213;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        int[] alphabetCount = new int[26];
        for(char c : name.toCharArray()) {
            alphabetCount[c - 'A']++;
        }

        // 불가능한 경우 찾기
        int oddCount = 0;
        char oddAlphabet = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabetCount[i] % 2 != 0) {
                oddCount++;
                oddAlphabet = (char) (i + 'A'); // 홀수 문자가 뭔지 저장
            }
        }

        if (oddCount > 1) {
            System.out.println("I'm Sorry Hansoo");
            return; // 프로그램 종료
        }

        // 펠린드롬 만들기
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++) {
            for (int j = 0; j < alphabetCount[i] / 2; j++) {
                sb.append((char) (i + 'A'));
            }
        }

        String front = sb.toString(); // .toString() 필수
        String back = sb.reverse().toString(); // sb를 뒤집어서 뒤쪽 완성

        StringBuilder result = new StringBuilder();
        result.append(front);
        if (oddCount == 1) result.append(oddAlphabet); // 홀수 문자가 있을 때만 추가
        result.append(back);

        System.out.println(result);
    }
}