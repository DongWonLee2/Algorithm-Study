package week02.boj_4949;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            String input = br.readLine();
            if(input.equals(".")) break;
            Deque<Character> stack = new ArrayDeque<>();
            for(char c : input.toCharArray()) {
                if(c == '(' || c == '[') {
                    stack.push(c);
                }
                if(c == ')') {
                    // 비어있거나 짝이 안맞으면
                    if(stack.isEmpty() || stack.peek() != '(') {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                } else if(c == ']') {
                    if(stack.isEmpty() || stack.peek() != '[') {
                        stack.push(c);
                        break;
                    }
                    stack.pop();
                }
            }

            if(stack.isEmpty()) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }
        System.out.print(sb);
    }
}
