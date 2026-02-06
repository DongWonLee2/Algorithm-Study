package week04.boj_1644;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> primes = new ArrayList<>();

        getPrime(N, primes);
        int size = primes.size();

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while(true) {
            if(sum >= N) {
                sum -= primes.get(left++);
            }
            else if(right == size) {
                break;
            }
            else {
                sum += primes.get(right++);
            }

            if(sum == N) count++;
        }

        System.out.print(count);
    }

    private static void getPrime(int n, List<Integer> l) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i = 2; i * i <= n; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i <= n; i++) {
            if(isPrime[i]) l.add(i);
        }
    }
}
