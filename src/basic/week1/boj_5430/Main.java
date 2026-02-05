package basic.week1.boj_5430;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            String ac = br.readLine();
            int N = Integer.parseInt(br.readLine());
            dq.clear(); // 모든 요소를 null로 초기화해서 시간은 더 걸리지만 메모리는 줄임.
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            while(st.hasMoreTokens()) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean isFront = true; // true: 앞, flase: 뒤
            boolean error = false;
            for(char c : ac.toCharArray()) {
                if(c == 'R') {
                    isFront = !isFront;
                } else {
                    if(dq.isEmpty()) {
                        error = true;
                        break;
                    }
                    if(isFront) {
                        dq.poll();
                    } else {
                        dq.pollLast();
                    }
                }
            }

            if(error) {
                sb.append("error\n");
            } else {
                makePrint(dq, isFront, sb);
            }
        }

        System.out.print(sb);
    }

    private static void makePrint(Deque<Integer> dq, boolean isFront, StringBuilder sb) {
        sb.append("[");
        while(!dq.isEmpty()) {
            if(isFront) sb.append(dq.poll());
            else sb.append(dq.pollLast());
            if(!dq.isEmpty()) sb.append(",");
        }
        sb.append("]\n");
    }
}
