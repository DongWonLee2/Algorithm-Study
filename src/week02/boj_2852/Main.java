package week02.boj_2852;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tGoal = new int[3];
        int[] tTime = new int[3];
        int currTime = 0;
        int lastTime = 0;
        int winTeam1 = 0;
        int winTeam2 = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            String timeStr = st.nextToken();
            String[] time = timeStr.split(":");
            currTime = (Integer.parseInt(time[0]) * 60) + Integer.parseInt(time[1]);

            if(tGoal[1] > tGoal[2]) {
                winTeam1 += currTime - lastTime;
            }
            else if(tGoal[1] < tGoal[2]) {
                winTeam2 += currTime - lastTime;
            }
            tGoal[team] += 1;

            lastTime = currTime;
        }
        if(tGoal[1] > tGoal[2]) {
            winTeam1 += 2880 - currTime;
        }
        else if(tGoal[1] < tGoal[2]) {
            winTeam2 += 2880 - currTime;
        }

        System.out.println(String.format("%02d:%02d", winTeam1 / 60, winTeam1 % 60));
        System.out.println(String.format("%02d:%02d", winTeam2 / 60, winTeam2 % 60));
    }
}
