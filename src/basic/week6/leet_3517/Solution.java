package basic.week6.leet_3517;

class Solution {
    public String smallestPalindrome(String s) {
        int[] alpha = new int[26];
        for(char c : s.toCharArray()) {
            alpha[c - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        String middle = "";
        for(int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            if(alpha[i] % 2 != 0) middle = String.valueOf(c);

            int count = alpha[i] / 2;
            if(count == 0) continue;

            for(int j = 0; j < count; j++) sb.append(c);
        }
        StringBuilder result = new StringBuilder(sb);
        if(!middle.equals("")) result.append(middle);
        result.append(sb.reverse());

        return result.toString();
    }
}
