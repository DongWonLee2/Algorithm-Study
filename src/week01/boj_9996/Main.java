package week01.boj_9996;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] files = new String[n];

        for(int i = 0; i < n; i++) {
            files[i] = br.readLine();
        }

        int idx = pattern.indexOf('*');
        String front = pattern.substring(0, idx);
        String back = pattern.substring(idx + 1);

        for(int i = 0; i < n; i++) {
            if(check(files[i], front, back)) {
                System.out.println("DA");
            }
            else {
                System.out.println("NE");
            }
        }
    }

    private static boolean check(String file, String front, String back) {
        int fLength = front.length();
        int bLength = back.length();
        int fileLength = file.length();

        if(fileLength < fLength + bLength) {
            return false;
        }

        if(file.substring(0, fLength).equals(front)) {
            if(file.substring(file.length() - bLength).equals(back)) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }
}
