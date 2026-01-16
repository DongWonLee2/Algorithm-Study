package week01.boj_1629;

import java.util.Scanner;

public class Recursion {
    static long c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        c = sc.nextLong();

        System.out.println(rec(a, b));
    }

    private static long rec(long a, long b) {
        // 기저 조건
        if(b == 1) return a % c;

        // 절반 구하기(한 번만 구해서 재사용)
        long temp = rec(a, b / 2);

        // 절반 제곱
        long result = (temp * temp) % c;

        if(b % 2 == 0) {
            return result;
        } else {
            return (result * a) % c;
        }
    }
}
