package week04.boj_2109;

import java.util.*;
import java.io.*;

public class Main {

    static class Lecture {
        int pay, day;
        Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Lecture[] lecArray = new Lecture[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            lecArray[i] = new Lecture(p, d);
        }

        Arrays.sort(lecArray, Comparator
                .comparingInt((Lecture l) -> l.day));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Lecture l : lecArray) {
            pq.offer(l.pay);
            if(pq.size() > l.day) {
                pq.poll();
            }
        }

        int salary = 0;
        while(!pq.isEmpty()) {
            salary += pq.poll();
        }

        System.out.print(salary);
    }
}
