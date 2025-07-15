package challenges.baekjoon.silver4.p11399;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            P[i] = sc.nextInt();
        }

        Arrays.sort(P);

        int total = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += P[i];
            total += sum;
        }

        System.out.println(total);
    }
}