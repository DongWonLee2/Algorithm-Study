package basic.week5.lv2_소수찾기;

import java.util.*;

public class Solution2 {
    HashSet<Integer> numberSet = new HashSet<>();
    public void recursive(String comb, String others) {
        // 1. 현재 조합을 set에 추가한다.
        if(!comb.equals("")) {
            // 컬렉션(List, Map, Set)에 담을 때 어차피 객체로 들어가야 하니, 캐싱을 활용하는 게 메모리상 이득
            numberSet.add(Integer.valueOf(comb));
        }
        // 2. 남은 숫자 중 한개를 더 해 새로운 조합을 만든다.
        for(int i = 0; i < others.length(); i++) {
            recursive(comb + others.charAt(i), others.substring(0, i) + others.substring(i + 1));
        }
    }

    public static boolean isPrime(int num) {
        // 1. 0과 1은 소수가 아니다.
        if(num == 0 || num == 1) return false;

        // 2. 에라토스테네스의 체의 Limit을 계산한다.
        int limit = (int) Math.sqrt(num);

        // 3. 에라토스테네스의 체에 따라 Limit까지만 배수 여부를 확인한다.
        for(int i = 2; i <= limit; i++) {
            if(num % i == 0) return false;
        }

        return true;
    }

    public int solution(String numbers) {
        // 1. 모든 조합의 숫자를 만든다.
        recursive("", numbers);

        // 2. 소수의 개수만 센다.
        int count = 0;
        Iterator<Integer> it = numberSet.iterator(); // 다양한 자료구조를 공통되게 활용할 수 있음.
        while(it.hasNext()) {
            int number = it.next();
            if(isPrime(number)) count++;
        }

        // 3. 소수의 개수를 반환한다.
        return count;
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.print(sol.solution("17"));
    }
}
