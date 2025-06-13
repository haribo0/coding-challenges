package challenges.baekjoon.silver2.p15988;

import java.io.*;

public class Main {

    static final int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] testCases = new int[T];
        int maxN = 0;
        for (int i = 0; i < T; i++) {
            testCases[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, testCases[i]);
        }

        int[] dp = new int[maxN + 1];
        dp[0] = 1;
        if (maxN >= 1) dp[1] = 1;
        if (maxN >= 2) dp[2] = 2;
        if (maxN >= 3) dp[3] = 4;

        for (int i = 4; i <= maxN; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int n : testCases) {
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
