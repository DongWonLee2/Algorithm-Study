package week02.boj_2828;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(br.readLine());
        int bucketLeft = 1;
        int bucketRight = bucketLeft + m - 1;
        int count = 0;

        for(int i = 0; i < j; i++) {
            int applePoint = Integer.parseInt(br.readLine());
            if(applePoint >= bucketLeft && applePoint <= bucketRight) continue;
            else if(applePoint > bucketRight) {
                count += applePoint - bucketRight;
                bucketRight = applePoint;
                bucketLeft = bucketRight - m + 1;
            }
            else {
                count += bucketLeft - applePoint;
                bucketLeft = applePoint;
                bucketRight = bucketLeft + m - 1;
            }
        }

        System.out.print(count);
    }

}
