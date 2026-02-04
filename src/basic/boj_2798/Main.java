package basic.boj_2798;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cards = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cards);
        int result = 0;
        for(int i = 0; i < N; i++) {
            if(cards[i] > M) break;
            for(int j = i + 1; j < N; j++) {
                if(cards[j] > M) break;
                for(int k = j + 1; k < N; k++) {
                    if(cards[k] > M) break;

                    int temp = cards[i] + cards[j] + cards[k];

                    if(temp <= M ) {
                        result = Math.max(result, temp);
                    } else {
                        break;
                    }

                    if(result == M) {
                        System.out.print(result);
                        return;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
