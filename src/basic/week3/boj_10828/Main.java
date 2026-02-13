package basic.week3.boj_10828;

import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> stack = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push" :
                    int x = Integer.parseInt(st.nextToken());
                    push(x);
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty" :
                    empty();
                    break;
                case "top" :
                    top();
                    break;
            }
        }
    }
    public static void push(int x) {
        stack.add(x);
    }
    public static void pop() {
        if(stack.isEmpty()) {
            System.out.println(-1);
        }
        else {
            System.out.println(stack.remove(stack.size() - 1));
        }
    }
    public static void size() {
        System.out.println(stack.size());
    }
    public static void empty() {
        if(stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    public static void top() {
        if(stack.isEmpty()) {
            System.out.println(-1);
        }
        else{
            System.out.println(stack.get(stack.size() - 1));
        }
    }
}
