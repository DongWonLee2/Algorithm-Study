package basic.week8.boj_1021;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution2();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 1; i <= m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = 0;
            for(int d : deque) {
                if(d == target) {
                    break;
                }
                targetIdx++;
            }

            int size = deque.size();
            if(targetIdx <= size / 2) {
                for(int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                for(int j = 0; j < size - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }

    private void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            deque.offerLast(i);
        }

        st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i = 1; i <= m; i++) {
            int target = Integer.parseInt(st.nextToken());
            int targetIdx = deque.indexOf(target);
            int size = deque.size();

            if(targetIdx <= size / 2) {
                for(int j = 0; j < targetIdx; j++) {
                    deque.offerLast(deque.pollFirst());
                    count++;
                }
            }
            else {
                for(int j = 0; j < size - targetIdx; j++) {
                    deque.offerFirst(deque.pollLast());
                    count++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(count);
    }
}
