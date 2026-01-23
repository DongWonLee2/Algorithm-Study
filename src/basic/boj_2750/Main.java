package basic.boj_2750;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numList = new ArrayList<>();

        while(n != 0) {
            int i = Integer.parseInt(br.readLine());
            numList.add(i);
            n--;
        }
        numList.sort(Comparator.naturalOrder());
        // Collections.sort(numList);

        StringBuilder sb = new StringBuilder();
        for(int num : numList) {
            sb.append(num).append("\n");
        }
        /*
            for(int i = 0; i < numList.size(); i++) {
                sb.append(numList.get(i)).append("\n");
            }
         */


        System.out.print(sb);
    }
}
