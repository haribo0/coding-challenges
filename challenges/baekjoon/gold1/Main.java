package challenges.baekjoon.gold1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        double[] angles = new double[N];
        for (int i = 0; i < N; i++) {
            angles[i] = sc.nextDouble();
        }

        Arrays.sort(angles);
        double sector = 360.0 / K;

        double[] extended = new double[2 * N];
        for (int i = 0; i < N; i++) {
            extended[i] = angles[i];
            extended[i + N] = angles[i] + 360.0;
        }

        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            double start = angles[i];
            int[] counts = new int[K];

            for (int j = 0; j < K; j++) {
                double left = start + j * sector;
                double right = start + (j + 1) * sector;

                int cnt = 0;
                for (int p = 0; p < 2 * N; p++) {
                    if (extended[p] > left && extended[p] < right) {
                        cnt++;
                    }
                }

                counts[j] = cnt;
            }

            int max = Arrays.stream(counts).max().getAsInt();
            int min = Arrays.stream(counts).min().getAsInt();
            result = Math.min(result, max - min);
        }

        System.out.println(result);
    }
}
