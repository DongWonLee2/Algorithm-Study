package basic.boj_18870;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = sorted[i] = Integer.parseInt(st.nextToken());
        }

        // 전체 정렬 (O(N log N))
        Arrays.sort(sorted);

        // 중복 제거 (Unique 배열 만들기)
        // 정렬된 배열에서 인접한 값이 다를 때만 앞으로 당겨서 채웁니다.
        int uniqueCount = 0; // 쓰기 포인터
        if (N > 0) {
            uniqueCount = 1;
            for (int i = 1; i < N; i++) { // i는 읽기 포인터
                if (sorted[i] != sorted[i - 1]) {
                    sorted[uniqueCount++] = sorted[i];
                }
            }
        }

        // Binary Search로 결과 도출 (O(N log M))
        StringBuilder sb = new StringBuilder();
        for (int val : origin) {
            // Arrays.binarySearch는 찾은 값의 인덱스를 반환합니다.
            // uniqueCount 범위까지만 탐색하도록 지정합니다.
            int rank = Arrays.binarySearch(sorted, 0, uniqueCount, val);
            sb.append(rank).append(" ");
        }

        System.out.println(sb);
    }
}
