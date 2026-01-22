package week02.boj_2910;

import java.util.*;
import java.io.*;

public class Improve {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // LinkedHashMap으로 빈도 저장 및 삽입 순서 유지
        Map<Integer, Integer> map = new LinkedHashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Key들을 리스트로 추출. 이때 리스트는 이미 등장 순서대로 정렬됨
        List<Integer> list = new ArrayList<>(map.keySet());

        // 빈도수 기준 내림차순 정렬만 수행
        // TimSort이므로 빈도수가 같으면 기존의 등장 순서가 보존됨
        list.sort((a, b) -> map.get(b).compareTo(map.get(a)));

        StringBuilder sb = new StringBuilder();
        for (int key : list) {
            int count = map.get(key);
            while (count-- > 0) {
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb);
    }
}
