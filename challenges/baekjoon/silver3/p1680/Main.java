package challenges.baekjoon.silver3.p1680;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t=0; t<T; t++) {
            int W = sc.nextInt(); // 쓰레기차 용량
            int N = sc.nextInt(); // 지점 수
            
            int[] x = new int[N]; // 거리
            int[] w = new int[N]; // 쓰레기 양
            
            for (int i = 0; i < N; i++) {
                x[i] = sc.nextInt();
                w[i] = sc.nextInt();
            }
            
            int totalDistance = calculateTotalDistance(W, N, x, w);
            System.out.println(totalDistance);
        }
    }

    private static int calculateTotalDistance(int W, int N, int[] x, int[] w) {
        int dist = 0;
        int load = 0;
        int i = 0;

        while (i < N) {
            if (load + w[i] > W) {
                dist += 2 * x[i];
                load = 0;
            }
            load += w[i];
            if (load == W) {
                dist += 2 * x[i];
                load = 0;
            }
            i++;
        }

        if (load > 0) {
            dist += 2 * x[N - 1];
        }

        return dist;
    }
}
