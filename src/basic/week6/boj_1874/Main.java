package basic.week6.boj_1874;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(sc.nextLine());
            if (num > start) {
                for(int j = start + 1; j <= num; j++) {
                    stack.push(j);
                    sb.append("+").append("\n");
                }
                stack.pop();
                sb.append("-").append("\n");
                start = num;
            }
            else {
                if(stack.peek() == num) {
                    stack.pop();
                    sb.append("-").append("\n");
                }
            }
        }

        if(stack.isEmpty()) {
            System.out.print(sb);
        }
        else {
            System.out.print("NO");
        }
    }
}

