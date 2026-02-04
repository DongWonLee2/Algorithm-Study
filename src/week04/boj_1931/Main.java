package week04.boj_1931;

import java.util.*;
import java.io.*;

public class Main {

    static class Meeting{
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // List<Meeting> meetList = new ArrayList<>();

        // N이 100,000개면 ArrayList도 괜찮지만 메모리 효율을 높이려면 배열 선언으로 해서 객체 생성 오버헤드를 줄이는 게 좋다.
        Meeting[] meetArray = new Meeting[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // meetList.add(new Meeting(start, end));
            meetArray[i] = new Meeting(start, end);
        }

//        meetList.sort(Comparator
//                .comparingInt((Meeting m) -> m.end)
//                .thenComparingInt(m -> m.start));
        Arrays.sort(meetArray, Comparator
                .comparingInt((Meeting m) -> m.end)
                .thenComparingInt(m -> m.start));


        int lastEnd = 0;
        int count = 0;
//        for(Meeting m : meetList) {
//            if(lastEnd <= m.start) {
//                count++;
//                lastEnd = m.end;
//            }
//        }
        for(Meeting m : meetArray) {
            if(lastEnd <= m.start) {
                count++;
                lastEnd = m.end;
            }
        }

        System.out.print(count);
    }
}
