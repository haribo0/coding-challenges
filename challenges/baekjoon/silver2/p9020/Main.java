package challenges.baekjoon.silver2.p9020;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MAX = 10000;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        setPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = n / 2; i >= 2; i--) {
                if (isPrime[i] && isPrime[n - i]) {
                    System.out.println(i + " " + (n - i));
                    break;
                }
            }
        }
    }

    private static void setPrime() {
        for (int i = 2; i <= MAX; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}

