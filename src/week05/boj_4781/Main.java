package week05.boj_4781;

import java.util.*;
import java.io.*;

public class Main {

    static class Candy {
        int calorie;
        int price;
        Candy(int calorie, int price) {
            this.calorie = calorie;
            this.price = price;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            float m = Float.parseFloat(st.nextToken()); // Or. int exM = Integer.parseInt(mStr.replace(".", ""));

            if(n == 0) {
                break;
            }

            List<Candy> candyList = new ArrayList<>();
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int calorie = Integer.parseInt(st.nextToken());
                float price = Float.parseFloat(st.nextToken());  // int exPrice = Integer.parseInt(pStr.replace(".", ""));
                int exPrice = (int) Math.round(price * 100);
                candyList.add(new Candy(calorie, exPrice));
            }
            candyList.sort(Comparator
                    .comparingInt((Candy c) -> c.price));

            int exM = (int) Math.round(m * 100);
            int[] DP = new int[exM + 1];

            int max = 0;
            for(int i = 1; i <= exM; i++) {
                for(Candy c : candyList) {
                    int currCal = c.calorie;
                    int currPrice = c.price;

                    if(i < currPrice) break;
                    DP[i] = Math.max(DP[i - currPrice] + currCal, DP[i]);
                    max = Math.max(DP[i], max);
                }
            }
            sb.append(max).append("\n");
        }

        System.out.print(sb);
    }
}
