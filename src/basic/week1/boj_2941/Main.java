package basic.week1.boj_2941;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String Croatia = input.replaceAll("c=", "1");
        Croatia = Croatia.replaceAll("c-", "1");
        Croatia = Croatia.replaceAll("dz=", "1"); // 더 긴 패턴(dz=)을 'z='보다 먼저 처리
        Croatia = Croatia.replaceAll("d-", "1");
        Croatia = Croatia.replaceAll("lj", "1");
        Croatia = Croatia.replaceAll("nj", "1");
        Croatia = Croatia.replaceAll("s=", "1");
        Croatia = Croatia.replaceAll("z=", "1");

        System.out.print(Croatia.length());
    }
}
