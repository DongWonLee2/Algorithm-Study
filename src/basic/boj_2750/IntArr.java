package basic.boj_2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class IntArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numArr = new int[n];

        for(int i = 0; i < n; i++) {
            numArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numArr);

        StringBuilder sb = new StringBuilder();
        for(int num : numArr) {
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
