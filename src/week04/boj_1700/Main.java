package week04.boj_1700;

import java.util.*;
import java.io.*;

public class Main {

    static int K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] seqElec = new int[K];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++) {
            int a = Integer.parseInt(st.nextToken());
            seqElec[i] = a;
        }

        Set<Integer> multitap = new HashSet<>();
        int count = 0;
        for(int i = 0; i < K; i++) {
            int currElec = seqElec[i];
            if(multitap.size() < N && !multitap.contains(currElec)) {
                multitap.add(currElec);
                continue;
            }
            else if(multitap.size() >= N && !multitap.contains(currElec)) {
                int elec = getRemoveElec(i, multitap, seqElec);
                count++;
                multitap.remove(elec);
                multitap.add(currElec);
            }
        }
        System.out.print(count);
    }

    private static int getRemoveElec(int i, Set<Integer> multitap, int[] seqElec) {
        int maxIdxElec = 0;
        for(int e : multitap) {
            for(int j = i + 1; j < K; j++) {
                if(e == seqElec[j]) {
                    maxIdxElec = Math.max(maxIdxElec, j);
                    break;
                }
                if(j == K - 1) {
                    return e;
                }
            }
        }
        return seqElec[maxIdxElec];
    }
}
