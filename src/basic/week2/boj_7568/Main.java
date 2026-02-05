package basic.week2.boj_7568;

import java.util.*;
import java.io.*;

public class Main {

    static class Human{
        int weight, height;

        Human(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
    static Human[] humans;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        humans = new Human[N];
        int[] result = new int[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            humans[i] = new Human(w, h);
        }

        for(int i = 0; i < N; i++) {
            result[i] = solve(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i : result) {
            sb.append(i).append(" ");
        }

        System.out.print(sb);
    }

    private static int solve(int idx) {
        int currW = humans[idx].weight;
        int currH = humans[idx].height;

        int count = 0;
        for(int i = 0; i < N; i++) {
            if(i == idx) continue;
            if(currW < humans[i].weight && currH < humans[i].height) {
                count++;
            }
        }
        return count + 1;
    }
}
