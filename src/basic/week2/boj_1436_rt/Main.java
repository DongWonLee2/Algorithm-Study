package basic.week2.boj_1436_rt;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = 666;
        int seq = 1;
        while(true) {
            if(check(i)) {
                if(seq == N) {
                    break;
                }
                else {
                    i++;
                    seq++;
                }
            } else {
                i++;
            }
        }

        System.out.print(i);
    }

    private static boolean check(int i) {
        String s = Integer.toString(i);
        return s.contains("666");
    }
}