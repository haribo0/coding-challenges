package challenges.baekjoon.silver1.p1124;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        
        final int MAX = 100000;
        
        // 에라토스테네스의 체
        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // 소수들의 목록을 배열에 저장
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= MAX; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        // 소수의 개수 배열
        int[] factorCount = new int[MAX + 1];
        
        // 각 수에 대해 소인수 개수 계산
        for (int i = 2; i <= MAX; i++) {
            int num = i;
            for (int prime : primes) {
                if (prime * prime > num) break;
                while (num % prime == 0) {
                    factorCount[i]++;
                    num /= prime;
                }
            }
            if (num > 1) {  // num이 여전히 소수라면
                factorCount[i]++;
            }
        }

        // 언더프라임 계산 (소인수 개수가 소수인 수 세기)
        int underPrimeCount = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[factorCount[i]]) {
                underPrimeCount++;
            }
        }

        System.out.println(underPrimeCount);
    }
}
