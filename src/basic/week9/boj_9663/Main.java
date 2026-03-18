package basic.week9.boj_9663;

import java.util.*;

public class Main {
    int n;
    int[] queens; // queens[row] = col
    int result;

    public static void main(String[] args) {
        Main main = new Main();
        main.solution();
    }

    private void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        queens = new int[n];

        solve(0);

        System.out.println(result);
    }

    private void solve(int row) {
        if(row == n) {
            result++;
            return;
        }

        for(int c = 0; c < n; c++) {
            if(isValid(row, c)) {
                queens[row] = c;
                solve(row + 1);
            }
        }
    }

    private boolean isValid(int row, int col) {
        for(int r = 0; r < row; r++) {
            // 같은 열 체크
            if(queens[r] == col) return false;

            // 대각선 체크
            if(Math.abs(r - row) == Math.abs(queens[r] - col)) return false;
        }
        return true;
    }
}
