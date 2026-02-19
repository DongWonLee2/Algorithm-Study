package basic.week5.boj_2309;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] dwarfs = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++) {
            int n = sc.nextInt();
            sum += n;
            sc.nextLine();
            dwarfs[i] = n;
        }

        boolean find = false;
        for(int i = 0; i < 8; i++) {
            for(int j = i + 1; j < 9; j++) {
                int a = dwarfs[i];
                int b = dwarfs[j];
                if(sum - (a + b) == 100) {
                    dwarfs[i] = 0;
                    dwarfs[j] = 0;
                    find = true;
                    break;
                }
            }
            if(find) {
                break;
            }
        }

        Arrays.sort(dwarfs);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            if(dwarfs[i] == 0) continue;
            sb.append(dwarfs[i]).append("\n");
        }

        System.out.print(sb);
    }
}
