package basic.week5.boj_2231;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int result = 0;
        for(int i = 1; i < n; i++) {
            int sum = i;
            int temp = i;
            while(temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if(sum == n) {
                result = i;
                break;
            }
        }
        System.out.print(result);
    }
}
