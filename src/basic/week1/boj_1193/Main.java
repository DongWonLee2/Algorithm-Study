package basic.week1.boj_1193;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();

        if(X == 1) {
            System.out.print("1/1");
            return;
        }

        int count = 0;
        int sum = 2;
        int n = 1;
        for(int i = 1; i <= X; i++) {
            if(count == n) {
                sum++;
                n++;
                count = 0;
            }
            count++;
        }

        if(sum % 2 == 0) {
            int a = sum - count;
            int b = count;
            System.out.print(a + "/" + b);
        } else {
            int a = count;
            int b = sum - count;
            System.out.print(a + "/" + b);
        }
    }
}
