package week02.boj_2870;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<String> ans = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            char[] cs = str.toCharArray();

            for(char c : cs) {
                if(c >= '0' && c <= '9') { // Character.isDigit(c)
                    sb.append(c);
                } else {
                    if (sb.length() > 0) {
                        processNumber(sb, ans);
                    }
                }
            }
            if (sb.length() > 0) {
                processNumber(sb, ans);
            }
        }
        ans.sort((o1, o2) -> {
            if(o1.length() != o2.length()) return o1.length() - o2.length();
            return o1.compareTo(o2);
        });

        StringBuilder output = new StringBuilder();
        for(String s : ans) {
            output.append(s).append("\n");
        }
        System.out.print(output);
    }

    private static void processNumber(StringBuilder sb, List<String> ans) {
        String s = sb.toString().replaceAll("^0+", "");
        if(s.isEmpty()) s = "0";
        ans.add(s); // ans.add(s.isEmpty() ? "0" : s);
        sb.setLength(0);
    }
}
