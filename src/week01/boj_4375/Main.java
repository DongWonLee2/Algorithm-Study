package week01.boj_4375;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            long remainder = 0;
            for(int count = 1; ; count++) {
                remainder = (remainder * 10 + 1) % n;

                if(remainder == 0) {
                    System.out.println(count);
                    break;
                }
            }
        }
    }
}