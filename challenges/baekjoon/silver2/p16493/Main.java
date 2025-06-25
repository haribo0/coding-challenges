package challenges.baekjoon.silver2.p16493;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] day = new int[M];
        int[] page = new int[M];

        for (int i = 0; i < M; i++) {
            String[] chapter = br.readLine().split(" ");
            day[i] = Integer.parseInt(chapter[0]);
            page[i] = Integer.parseInt(chapter[1]);
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = N; j >= day[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - day[i]] + page[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
