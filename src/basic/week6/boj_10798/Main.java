package basic.week6.boj_10798;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[][] board = new char[5][15];
        for(int i = 0; i < 5; i++) {
            String str = sc.nextLine();
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                board[i][j] = c;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                char c = board[j][i];
                if(c == '\0') continue;
                sb.append(c);
            }
        }

        System.out.print(sb);
    }
}
