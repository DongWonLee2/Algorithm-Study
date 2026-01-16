package week01.boj_1629;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();

        a %= c; // 처음부터 a가 c보다 클 수 있기 때문에

        long ans = 1;
        while(b > 0) {
            if(b % 2 == 1) {
                ans = (ans * a) % c;
            }
            a = (a * a) % c;
            b /= 2;
        }

        System.out.println(ans % c);
    }
}
