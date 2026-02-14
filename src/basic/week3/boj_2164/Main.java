package basic.week3.boj_2164;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while(queue.size() > 1) {
            queue.poll();
            int a = queue.poll();
            queue.offer(a);
        }

        System.out.println(queue.poll());
    }
}
