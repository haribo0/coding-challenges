package challenges.baekjoon.silver2.p4097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            int maxSum, currentSum;

            // 첫 날 수익 처리
            int first = Integer.parseInt(br.readLine());
            maxSum = currentSum = first;

            for (int i = 1; i < N; i++) {
                int profit = Integer.parseInt(br.readLine());

                currentSum = Math.max(profit, currentSum + profit);
                maxSum = Math.max(maxSum, currentSum);
            }

            System.out.println(maxSum);
        }
    }
}
