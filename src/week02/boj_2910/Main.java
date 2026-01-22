package week02.boj_2910;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> numCount = new HashMap<>();
        Map<Integer, Integer> numSeq = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++) {
            int input = Integer.parseInt(st.nextToken());
            numCount.put(input, numCount.getOrDefault(input, 0) + 1);
            numSeq.put(input, numSeq.getOrDefault(input, i));
        }

        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(numCount.entrySet());
        entryList.sort((o1, o2) -> {
            // 빈도수(Value)가 다르다면 내림차순 정렬
            if (!o1.getValue().equals(o2.getValue())) {
                return o2.getValue().compareTo(o1.getValue());
            }
            // 빈도수가 같다면 등장 순서(numSeq)를 기준으로 오름차순 정렬
            return numSeq.get(o1.getKey()).compareTo(numSeq.get(o2.getKey()));
        });

        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Integer, Integer> entry : entryList) {
            int num = entry.getKey();
            int count = entry.getValue();

            for(int i = 0; i < count; i++) {
                sb.append(num).append(" ");
            }
        }
        System.out.print(sb);
    }
}
