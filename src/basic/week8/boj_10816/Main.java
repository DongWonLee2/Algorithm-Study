package basic.week8.boj_10816;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution2();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(num, 0)).append(" ");
        }

        System.out.println(sb);
    }

    private void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[n];
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            numArr[i] = num;
        }

        Arrays.sort(numArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = upperBound(numArr, num) - lowerBound(numArr, num);
            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    private int upperBound(int[] arr, int num) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;

            if(arr[mid] <= num) {
                low = mid + 1;
            }
            else high = mid;
        }

        return low;
    }

    private int lowerBound(int[] arr, int num) {
        int low = 0;
        int high = arr.length;

        while(low < high) {
            int mid = (low + high) / 2;

            if(arr[mid] < num) {
                low = mid + 1;
            }
            else high = mid;
        }

        return low;
    }
}
