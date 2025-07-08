package challenges.baekjoon.silver2.p2961;

import java.util.*;

public class Main {
    static int N;
    static int[] S;
    static int[] B;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = new int[N];
        B = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        dfs(0, 1, 0, false);
        System.out.println(minDiff);
        sc.close();
    }

    static void dfs(int idx, int totalS, int totalB, boolean used) {
        if (idx == N) {
            if (used) {
                minDiff = Math.min(minDiff, Math.abs(totalS - totalB));
            }
            return;
        }

        // 재료 선택
        dfs(idx + 1, totalS * S[idx], totalB + B[idx], true);
        // 재료 선택 안함
        dfs(idx + 1, totalS, totalB, used);
    }
}

