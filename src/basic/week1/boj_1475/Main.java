package basic.week1.boj_1475;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] numArr = new int[10];

        for(int i = 0; i < N.length(); i++){
            int num = N.charAt(i) - '0';

            if(num == 9) {
                numArr[6]++;
                continue;
            }
            numArr[num]++;
        }

        if(numArr[6] % 2 == 1) {
            numArr[6] = numArr[6] / 2 + 1;
        } else {
            numArr[6] /= 2;
        }

        int count = 0;
        for(int i : numArr) {
            count = Math.max(i, count);
        }

        System.out.println(count);
    }
}
