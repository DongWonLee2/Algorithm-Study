package basic.week5.boj_2941;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int idx = 0;
        int length = input.length();
        int count = 0;
        while(idx < length) {
            char firstC = input.charAt(idx);
            if(firstC == 'c') {
                if(idx + 1 < length && input.charAt(idx + 1) == '=') {
                    count++;
                    idx = idx + 2;
                }
                else if(idx + 1 < length && input.charAt(idx + 1) == '-') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            if(firstC == 'd') {
                if(idx + 1 < length && input.charAt(idx + 1) == 'z') {
                    if(idx + 2 < length && input.charAt(idx + 2) == '=') {
                        count++;
                        idx = idx + 3;
                    }
                    else {
                        count++;
                        idx = idx + 1;
                    }
                }
                else if(idx + 1 < length && input.charAt(idx + 1) == '-') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            if(firstC == 'l') {
                if(idx + 1 < length && input.charAt(idx + 1) == 'j') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            if(firstC == 'n') {
                if(idx + 1 < length && input.charAt(idx + 1) == 'j') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            if(firstC == 's') {
                if(idx + 1 < length && input.charAt(idx + 1) == '=') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            if(firstC == 'z') {
                if(idx + 1 < length && input.charAt(idx + 1) == '=') {
                    count++;
                    idx = idx + 2;
                }
                else {
                    count++;
                    idx = idx + 1;
                }
                continue;

            }
            count++;
            idx++;
        }

        System.out.print(count);
    }
}
