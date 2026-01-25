package week02.boj_9012;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            String input = br.readLine();
            Deque<Character> stack = new ArrayDeque<>();
            for(char c : input.toCharArray()) {
                if(c == ')'){
                    if(stack.isEmpty()) {
                        stack.push(c);
                        break;
                    }
                    if(stack.peek() == '(') {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.print(sb);
    }
}
