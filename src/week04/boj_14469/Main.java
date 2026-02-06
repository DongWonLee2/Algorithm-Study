package week04.boj_14469;

import java.util.*;
import java.io.*;

public class Main {

    static class Cow{
        int at, checkT;
        Cow(int at, int checkT) {
            this.at = at;
            this.checkT = checkT;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Cow> cows  = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int at = Integer.parseInt(st.nextToken());
            int checkT = Integer.parseInt(st.nextToken());

            cows.add(new Cow(at, checkT));
        }

        cows.sort(Comparator
                .comparingInt((Cow c) -> c.at));

        int currT = 0;
        int idx = 0;
        while(idx < cows.size()) {
            if(cows.get(idx).at <= currT) {
                currT += cows.get(idx).checkT;
                idx++;
            } else {
                currT++;
            }
        }

        System.out.print(currT);
    }
}
