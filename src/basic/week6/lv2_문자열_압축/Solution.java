package basic.week6.lv2_문자열_압축;

class Solution {
    public int solution(String s) {
        int answer = s.length();

        for (int n = 1; n <= s.length() / 2; n++) {
            StringBuilder compressed = new StringBuilder();
            String target = s.substring(0, n);
            int count = 1;

            for (int i = n; i < s.length(); i += n) {
                int end = Math.min(i + n, s.length());
                String next = s.substring(i, end);

                if (target.equals(next)) {
                    count++;
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(target);

                    target = next;
                    count = 1;
                }
            }

            if (count > 1) compressed.append(count);
            compressed.append(target);

            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}
