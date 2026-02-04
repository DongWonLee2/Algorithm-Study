package basic.boj_2231;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for(int i = 1; i < N; i++) {
            if(getSum(i) == N) {
                System.out.print(i);
                return;
            }
        }
        System.out.print(0);
    }

    private static int getSum(int i) {
        int sum = i;
        while(i > 0) {
            int a = i % 10;
            sum += a;
            i /= 10;
        }
        return sum;
    }
}
