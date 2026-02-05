package basic.week1.boj_2908;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = reverseInt(st.nextToken());
        int b = reverseInt(st.nextToken());

        System.out.print(Math.max(a, b));
    }

    private static int reverseInt(String s) {
        return Integer.parseInt(new StringBuilder(s).reverse().toString());
    }
}
