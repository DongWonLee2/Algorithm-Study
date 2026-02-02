package week03.boj_16637;

import java.util.*;
import java.io.*;

public class Main {

    static List<Integer> nums = new ArrayList<>();
    static List<Character> ops = new ArrayList<>();
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        for(int i = 0; i < N; i++) {
            char c = input.charAt(i);
            if(c - '0' >= 0 && c - '0' <= 9) {
                int num = c - '0';
                nums.add(num);
            } else {
                ops.add(c);
            }
        }

        DFS(nums.get(0), 0);
        System.out.print(max);
    }

    private static void DFS(int result, int opIdx) {
        if(opIdx >= ops.size()) {
            max = Math.max(max, result);
            return;
        }

        int res1 = calc(result, ops.get(opIdx), nums.get(opIdx + 1));
        DFS(res1, opIdx + 1);

        if(opIdx + 1 < ops.size()) {
            int nextCalc = calc(nums.get(opIdx + 1), ops.get(opIdx + 1), nums.get(opIdx + 2));
            int res2 = calc(result, ops.get(opIdx) , nextCalc);
            DFS(res2, opIdx + 2);
        }
    }

    private static int calc(int num1, char op, int num2) {
        switch(op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }
}
