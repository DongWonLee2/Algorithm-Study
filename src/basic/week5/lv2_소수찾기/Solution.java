package basic.week5.lv2_소수찾기;

import java.util.*;

class Solution {

    public int solution(String numbers) {

        HashSet<Integer> permutations = new HashSet<>();

        boolean[] visited = new boolean[numbers.length()];

        makePermutation(numbers, "", visited, permutations);

        return check(permutations);
    }

    private static void makePermutation(String numbers, String curr, boolean[] visited, HashSet<Integer> permutations) {
        if(!curr.equals("")) {
            permutations.add(Integer.parseInt(curr));
        }

        for(int i = 0; i < numbers.length(); i++) {
            if(visited[i]) continue;

            visited[i] = true;

            makePermutation(numbers, curr + numbers.charAt(i), visited, permutations);

            visited[i] = false;
        }
    }

    private static int check(HashSet<Integer> permutations) {
        int count = 0;
        for(int num : permutations) {
            if (num < 2) continue;

            boolean isPrime = true;
            for(int j = 2; j <= Math.sqrt(num); j++) {
                if(num % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) count++;
        }

        return count;
    }
}