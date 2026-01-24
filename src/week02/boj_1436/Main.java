package week02.boj_1436;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int num = 666;
        int count = 0;
        while(true) {
            //String temp = String.valueOf(num);
            if(String.valueOf(num).contains("666")) {
                count++;
            }
            if(count == N) {
                break;
            }
            num++;
        }
        System.out.print(num);
    }
}
