package basic.week8.boj_7662;

import java.util.*;
import java.io.*;

public class Main {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            solve(c);
        }

        System.out.println(sb);
    }

    private void solve(int c) throws IOException {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char cal = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());

            if (cal == 'I') {
                treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
            } else {
                if (num == 1 && !treeMap.isEmpty()) {
                    int max = treeMap.lastKey();
                    if(treeMap.get(max) == 1) {
                        treeMap.remove(max);
                    }
                    else {
                        treeMap.put(max, treeMap.get(max) - 1);
                    }
                }
                else if (num == -1 && !treeMap.isEmpty()){
                    int min = treeMap.firstKey();
                    if(treeMap.get(min) == 1) {
                        treeMap.remove(min);
                    }
                    else {
                        treeMap.put(min, treeMap.get(min) - 1);
                    }
                }
            }
        }
        if(treeMap.isEmpty()) {
            sb.append("EMPTY").append("\n");
        }
        else{
            sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
        }
    }
}
