package basic.week6.lv2_괄호_회전하기;

import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> dq = new ArrayDeque<>();

        int length = s.length();
        for(int i = 0; i < length; i++) {
            dq.offer(s.charAt(i));
        }

        int answer = 0;
        if(checkb(dq)) answer += 1;
        for(int t = 1; t < length; t++) {
            turn(dq);
            if(checkb(dq)) answer += 1;
        }

        return answer;
    }

    private static void turn(Deque<Character> dq) {
        dq.offerLast(dq.pollFirst());
    }

    private static boolean check(Deque<Character> dq) {
        Deque<Character> st = new ArrayDeque<>();
        for(Character c : dq) {
            if(c == '[' || c == '(' || c == '{') {
                st.push(c);
            }
            else {
                if(st.isEmpty()) return false;

                char top = st.peek();
                if(top == '[' && c == ']') {
                    st.pop();
                    continue;
                }
                if(top == '(' && c == ')') {
                    st.pop();
                    continue;
                }
                if(top == '{' && c == '}') {
                    st.pop();
                    continue;
                }
            }
        }

        return st.isEmpty();
    }

    private static boolean checkb(Deque<Character> dq) {
        // ArrayDeque를 스택으로 활용할 때는 방향을 명확히 해야 함
        Deque<Character> st = new ArrayDeque<>();

        for(Character c : dq) {
            if(!st.isEmpty()) {
                // 맨 뒤(가장 최근 데이터)를 확인: peekLast()
                if(st.peek() == '[' && c == ']') {
                    st.pop(); // 맨 뒤 데이터 제거: pollLast()
                    continue;
                }
                if(st.peek() == '(' && c == ')') {
                    st.pop();
                    continue;
                }
                if(st.peek() == '{' && c == '}') {
                    st.pop();
                    continue;
                }
            }

            // 여는 괄호나 매칭 실패 시 맨 뒤에 추가
            st.push(c);
        }

        return st.isEmpty();
    }
}