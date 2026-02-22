package basic.week5.boj_5430;

import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String function = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> nums = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");

            for(int i = 0; i < n; i++) {
                nums.add(Integer.parseInt(st.nextToken()));
            }

            solve(function, nums);
        }

        System.out.print(sb);
    }

    private static void solve(String func, Deque<Integer> dq) {
        int length = func.length();
        boolean isFront = true;

        for(int i = 0; i < length; i++) {
            char f = func.charAt(i);
            switch(f) {
                case 'R' :
                    isFront = !isFront;
                    break;
                case 'D' :
                    if(dq.size() > 0) {
                        if(isFront) {
                            dq.pollFirst();
                        } else {
                            dq.pollLast();
                        }
                        break;
                    } else {
                        sb.append("error").append("\n");
                        return;
                    }
            }
        }

        sb.append("[");
        if(isFront) {
            while(dq.size() > 0) {
                sb.append(dq.pollFirst());
                if(!dq.isEmpty()) sb.append(",");
            }
        } else {
            while(dq.size() > 0) {
                sb.append(dq.pollLast());
                if(!dq.isEmpty()) sb.append(",");
            }
        }

        // sb.deleteCharAt(sb.length() - 1);
        sb.append("]").append("\n");
    }
}
