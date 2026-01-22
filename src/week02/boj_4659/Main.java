package week02.boj_4659;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            String str = br.readLine();
            if(str.equals("end")) break;

            boolean isAcceptable = true;
            boolean hasVowel = false;
            int vCount = 0;
            int cCount = 0;

            for(int i = 0; i < str.length(); i++) {
                char curr = str.charAt(i);
                boolean isCurrVowel = isVowel(curr);

                if(isCurrVowel) hasVowel = true;

                if(isCurrVowel) {
                    vCount++;
                    cCount = 0;
                } else {
                    cCount++;
                    vCount = 0;
                }
                if(vCount == 3 || cCount == 3) {
                    isAcceptable = false;
                    break;
                }

                if(i > 0 && curr == str.charAt(i - 1)) {
                    if(curr != 'o' && curr != 'e') {
                        isAcceptable = false;
                        break;
                    }
                }
            }
            if(!hasVowel) isAcceptable = false;

            if(isAcceptable) {
                sb.append("<").append(str).append("> ").append("is acceptable.\n");
            } else {
                sb.append("<").append(str).append("> ").append("is not acceptable.\n");
            }
        }
        System.out.println(sb);
    }

    private static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
