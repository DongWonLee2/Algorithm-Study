package basic.week3.boj_14425;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> sSet = new HashSet<>((int) (N / 0.75 + 1));
        for(int i = 0; i < N; i++) {
            sSet.add(br.readLine());
        }

        int count = 0;
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            if(sSet.contains(input)) {
                count++;
            }
        }

        System.out.print(count);
    }
}
