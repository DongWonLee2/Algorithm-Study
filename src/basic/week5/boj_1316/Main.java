package basic.week5.boj_1316;

import java.util.*;

public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < N; i++) {
            solve(sc.nextLine());
        }

        System.out.print(count);
    }

    private static void solve(String str) {
        int length = str.length();
        boolean isGroup = true;

        for(int i = 0; i < length; i++) {
            char checkC = str.charAt(i);
            char lastC = str.charAt(i);
            for (int j = i + 1; j < length; j++) {
                char curr = str.charAt(j);
                if (checkC == curr && lastC == curr) {
                    continue;
                }
                if (checkC == curr && lastC != curr) {
                    isGroup = false;
                    break;
                }
                lastC = str.charAt(j);
            }
            if (!isGroup) {
                break;
            }
        }

        if(isGroup) {
            count++;
        }
    }

    private static void solve2(String str) {
        boolean[] visited = new boolean[26];
        int prev = -1;

        for(int i = 0; i < str.length(); i++) {
            int curr = str.charAt(i);

            if(prev != curr) {
                if(visited[curr - 'a']) {
                    return;
                }
                visited[curr - 'a'] = true;
                prev = curr;
            }
        }

        count++;
    }
}
