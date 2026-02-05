package basic.week2.boj_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class TreeS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> ts = new TreeSet<>();

        while(n != 0) {
            int i = Integer.parseInt(br.readLine());
            ts.add(i);
            n--;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : ts) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
