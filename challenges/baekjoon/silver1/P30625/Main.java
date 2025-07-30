package challenges.baekjoon.silver1.P30625;

import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] A = new int[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt(); // 춤 종류 (1~M)
            B[i] = sc.nextInt(); // 방향 (0: 앞, 1: 뒤)
        }
        sc.close();

        long correct = 1;  // dp[i][0]
        long wrong = 0;    // dp[i][1]

        for (int i = 0; i < N; i++) {
            long newCorrect = 0;
            long newWrong = 0;

            if (B[i] == 0) { // 우진이 앞 → 같은 춤 == 정답
                newCorrect = correct * 1 % MOD;
                newWrong = (wrong * 1 + correct * (M - 1)) % MOD;
            } else { // 우진이 뒤 → 다른 춤 == 정답
                newCorrect = correct * (M - 1) % MOD;
                newWrong = (wrong * (M - 1) + correct * 1) % MOD;
            }

            correct = newCorrect;
            wrong = newWrong;
        }

        System.out.println((correct + wrong) % MOD);
    }
}
