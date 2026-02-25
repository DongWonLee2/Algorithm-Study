package basic.week6.lv2_뉴스_클러스터링;

import java.util.*;

class Solution {
    public int solution(String stra, String strb) {
        HashMap<String, Integer> str1Map = new HashMap<>();
        HashMap<String, Integer> str2Map = new HashMap<>();

        String str1 = stra.toLowerCase();
        String str2 = strb.toLowerCase();

        for(int i = 0; i < str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i + 1);

            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String str = str1.substring(i, i + 2);
                str1Map.put(str, str1Map.getOrDefault(str, 0) + 1);
            }
        }

        for(int i = 0; i < str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i + 1);
            if (Character.isAlphabetic(c1) && Character.isAlphabetic(c2)) {
                String str = str2.substring(i, i + 2);
                str2Map.put(str, str2Map.getOrDefault(str, 0) + 1);
            }
        }

        if (str1Map.isEmpty() && str2Map.isEmpty()) return 65536;

        int union = 0;
        int intersection = 0;
        Set<String> allKeys = new HashSet<>();
        allKeys.addAll(str1Map.keySet());
        allKeys.addAll(str2Map.keySet());

        for (String s : allKeys) {
            int count1 = str1Map.getOrDefault(s, 0);
            int count2 = str2Map.getOrDefault(s, 0);

            intersection += Math.min(count1, count2);
            union += Math.max(count1, count2);
        }

        int answer = (int) ((double) intersection / union * 65536);
        return answer;
    }
}
