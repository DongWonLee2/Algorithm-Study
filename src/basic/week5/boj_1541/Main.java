package basic.week5.boj_1541;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] minusGroups = input.split("-");

        int result = Integer.MAX_VALUE;

        for(String group : minusGroups) {
            StringTokenizer st = new StringTokenizer(group, "+");

            int sum = 0;
            while(st.hasMoreTokens()) {
                sum += Integer.parseInt(st.nextToken());
            }

            if(result == Integer.MAX_VALUE) {
                result = sum;
            } else {
                result -= sum;
            }
        }

        System.out.print(result);
    }
}
