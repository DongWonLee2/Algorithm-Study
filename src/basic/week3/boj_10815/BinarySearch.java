package basic.week3.boj_10815;

import java.util.*;
import java.io.*;

public class BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] sCards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            sCards[i] = Integer.parseInt(st.nextToken());
        }

        // 이진 탐색을 위해 반드시 정렬되어 있어야 함
        Arrays.sort(sCards);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            // Arrays.binarySearch는 값이 있으면 해당 인덱스(>=0), 없으면 음수를 반환함
            if (Arrays.binarySearch(sCards, target) >= 0) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }

        System.out.print(sb);
    }
}
