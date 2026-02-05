package basic.week1.boj_4673;

public class Main {
    public static void main(String[] args) {
        boolean[] hasDN = new boolean[10001];

        for(int n = 1; n <= 10000; n++) {
            int dn = getDn(n);

            if (dn <= 10000) {
                hasDN[dn] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= 10000; i++) {
            if(!hasDN[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int getDn(int n) {
        int res = n;
        while (n > 0) {
            res += n % 10; // 1의 자리 더하기
            n /= 10;       // 10으로 나눠서 자릿수 이동
        }
        return res;
    }
}
