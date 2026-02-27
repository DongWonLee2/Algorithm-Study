package basic.week6.lv1_신규_아이디_추천;

class Solution {
    public String solution(String new_id) {
        // 1
        String answer = "";
        new_id = new_id.toLowerCase();

        // 2
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(Character.isAlphabetic(c) || Character.isDigit(c) || c == '-' || c == '_' || c == '.') {
                answer += c;
            }
        }
        // 정규 표현식 활용
        answer = new_id.replaceAll("[^a-z0-9-_.]", "");

        // 3
        while(answer.indexOf("..") != -1) {
            answer = answer.replace("..", ".");
        }
        // 정규 표현식 활용
        answer = answer.replaceAll("\\.+", ".");

        // 4
        if(!answer.isEmpty() && answer.charAt(0) == '.') {
            answer = answer.substring(1);
        }
        if(!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') {
            answer = answer.substring(0, answer.length() - 1);
        }
        // 정규 표현식 활용
        answer = answer.replaceAll("^[.]|[.]$", "");

        // 5
        if(answer.isEmpty()) {
            answer = "a";
        }

        // 6
        if(answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if(answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
            // 정규 표현식 활용
            answer = answer.replaceAll("[.]$", "");
        }

        // 7
        while(answer.length() < 3) {
            answer += answer.charAt(answer.length() - 1);
        }

        return answer;
    }
}

/*
    정규표현식
    []: 대괄호 안의 모든 문자(or)
    [^]: 대괄호 안의 문자 외의 모든 문자(not)
    ^[]: 대괄호 안의 문자로 시작하는 문자열
    []$: 대괄호 안의 문자로 끝나는 문자열
    +: 1개 이상의 문자
    -: 사이의 문자 혹은 숫자. [a-z] : 알파벳 소문자 a부터 z까지 하나, [a-z0-9] : 알파벳 소문자 전체,0~9 중 한 문자
    *: 앞의 표현식이 없거나 있거나(여러 개)
    ?: 앞의 표현식이 없거나 최대 1개
    이스케이프(Escape) 처리: 정규식 특수 문자(., *, + 등)를 문자로 매핑하기 위해 사용.

    \w:	알파벳 대소문자+숫자+"_", [a-zA-Z_0-9]와 동일
    \W: \w의 부정(\w를 제외한 문자)
 */