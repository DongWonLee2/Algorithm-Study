package basic.week5.boj_13458;

import java.util.*;
import java.io.*;

public class Main {

    static int B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] people = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        long count = 0;
        for(int p : people) {
            count += solve(p);
        }

        System.out.print(count);
    }

    private static long solve(int p) {
        p -= B;
        long result = 1;

        if(p > 0)  {
            result += (long) p / C;
            if(p % C != 0) {
                result++;
            }
        }

        return result;
    }
}
