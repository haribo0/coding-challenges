package challenges.baekjoon.silver1.p10844;

import java.util.Scanner;

public class Main {
    static final int MOD = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[][] dp = new long[N + 1][10];

        // 길이 1일 때
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        for (int n = 2; n <= N; n++) {
            for (int k = 0; k <= 9; k++) {
                if (k > 0) dp[n][k] += dp[n - 1][k - 1];
                if (k < 9) dp[n][k] += dp[n - 1][k + 1];
                dp[n][k] %= MOD;
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result = (result + dp[N][i]) % MOD;
        }

        System.out.println(result);

        sc.close();
    }
}
