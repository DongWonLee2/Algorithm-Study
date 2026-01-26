package week02.boj_17298;

import java.util.*;
import java.io.*;

public class Main {

    static Deque<Integer> stack = new ArrayDeque<>();
    static int[] numArr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        numArr = new int[N + 1];
        result = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
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
            } else{
                sb.append(c).append(" ");
            }
        }
        System.out.print(sb);
    }

    private static void NGE(int i) {
        // 들어오는 수보다 작은 수가 stack에 더 이상 없을 때까지
        while(!stack.isEmpty() && numArr[i] > numArr[stack.peek()]){
            int n = stack.pop();
            result[n] = numArr[i];
        }
        stack.push(i);
    }
}
