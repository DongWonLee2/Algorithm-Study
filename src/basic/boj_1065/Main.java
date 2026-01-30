package basic.boj_1065;

import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i <= N; i++) {
            if(check(i)) {
                count++;
            }
        }

        System.out.print(count);
    }
    private static boolean check(int n) {
        int a = n % 10;
        n /= 10;
        int b = n % 10;
        int diff = a - b;
        n /= 10;
        while(n > 0) {
            int temp = n % 10;
            if(diff != b - temp) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
