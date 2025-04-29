package challenges.baekjoon.silver5.p1010;

import java.util.Scanner;

public class Main {

    public static long combination(int m, int n) {
        long result = 1L;
        for (int i = 1; i <= n; i++) {
            result *= (m - i + 1);
            result /= i;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();

        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int M = sc.nextInt();

            System.out.println(combination(M, N));
        }
        
        sc.close();
    }

}
