package basic.week8.boj_1158;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.solution2();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt() - 1;
        ArrayList<Integer> numList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            numList.add(i + 1);
        }

        int idx = k;
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while(numList.size() > 1) {
            int num = numList.remove(idx);
            sb.append(num).append(", ");
            idx = (idx + k) % numList.size();
        }

        sb.append(numList.get(0)).append(">");
        System.out.println(sb);
    }

    private void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < n; i++) {
            queue.add(i + 1);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(queue.size() > 1) {
            for(int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            sb.append(queue.poll()).append(", ");
        }
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}
