package basic.week6.lv2_다리를_지나는_트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new ArrayDeque<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int totalW = 0;
        int truckIdx = 0;
        int answer = 0;
        while(truckIdx < truck_weights.length) {
            answer++;

            totalW -= bridge.poll();
            int nextTruck = truck_weights[truckIdx];
            if(totalW + nextTruck > weight) {
                bridge.offer(0);
                continue;
            }
            bridge.offer(nextTruck);
            totalW += nextTruck;
            truckIdx++;
        }

        return answer + bridge_length;
    }
}