package basic.week8.boj_17298;

import java.io.*;
import java.util.*;

public class Main {
    Deque<Integer> stack = new ArrayDeque<>();
    int[] numArr;
    int[] result;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        numArr = new int[N + 1];
        result = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            NGE(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int c = result[i];
            if(c == 0) {
                sb.append(-1).append(" ");
            }
            else {
                sb.append(c).append(" ");
            }
        }

        System.out.println(sb);
    }

    private void NGE(int i) {
        while(!stack.isEmpty() && numArr[i] > numArr[stack.peek()]) {
            int n = stack.pop();
            result[n] = numArr[i];
        }
        stack.push(i);
    }
}
