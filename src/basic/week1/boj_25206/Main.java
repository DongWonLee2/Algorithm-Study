package basic.week1.boj_25206;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Float> gradeTable = Map.of(
                "A+", 4.5f, "A0", 4.0f, "B+", 3.5f, "B0", 3.0f,
                "C+", 2.5f, "C0", 2.0f, "D+", 1.5f, "D0", 1.0f, "F", 0.0f
        );

        float totalScore = 0;
        float totalCredit = 0;

        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            float credit = Float.parseFloat(st.nextToken());
            String gradeInput = st.nextToken();

            if (gradeInput.equals("P")) {
                continue;
            }

            totalCredit += credit;
            totalScore += (credit * gradeTable.get(gradeInput));
        }

        if (totalCredit != 0) {
            System.out.printf("%.6f", totalScore / totalCredit);
        } else {
            System.out.print("0.000000");
        }
    }
}
