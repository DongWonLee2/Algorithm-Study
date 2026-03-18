package basic.week8.boj_14719;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    int h, w;
    int[] mapH;
    int[] leftMax;
    int[] rightMax;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        mapH = new int[w];
        for(int i = 0; i < w; i++) {
            mapH[i] = Integer.parseInt(st.nextToken());
        }

        leftMax = new int[w];
        rightMax = new int[w];
        for(int i = 1; i < w - 1; i++) {
            // left
            for(int j = i - 1; j >= 0; j--) {
                leftMax[i] = Math.max(leftMax[i], mapH[j]);
            }

            // right
            for(int j = i + 1; j < w; j++) {
                rightMax[i] = Math.max(rightMax[i], mapH[j]);
            }
        }

        int result = 0;
        for(int i = 1; i < w - 1; i++) {
            if(mapH[i] > leftMax[i] || mapH[i] > rightMax[i]) continue;
            result += Math.min(leftMax[i], rightMax[i]) - mapH[i];
        }

        System.out.println(result);
    }
}
