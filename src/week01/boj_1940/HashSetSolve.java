package week01.boj_1940;

import java.util.*;
import java.io.*;

public class HashSetSolve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] items = new int[n];
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        HashSet<Integer> checkedItems = new HashSet<>();
        int count = 0;
        for(int i = 0; i < n; i++) {
            int item = items[i];
            int target = m - item;

            if(checkedItems.isEmpty()) {
                checkedItems.add(new Integer(item));
                continue;
            }
            if(checkedItems.contains(new Integer(target))) {
                count++;
            }
            checkedItems.add(new Integer(item));
        }
        System.out.println(count);
    }
}
