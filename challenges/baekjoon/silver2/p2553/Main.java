package challenges.baekjoon.silver2.p2553;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.close();

        int twoCount = 0;
        int fiveCount = 0;
        long result = 1;

        for (int i = 2; i <= N; i++) {
            int num = i;

            // 2와 5의 개수를 빼서 10이 되는 걸 방지
            while (num % 2 == 0) {
                twoCount++;
                num /= 2;
            }

            while (num % 5 == 0) {
                fiveCount++;
                num /= 5;
            }

            result *= num;
            result %= 100000000; // 충분히 큰 수로 자르되 정확성 유지
        }

        // 남은 2와 5의 차이만큼 보정
        int diff = twoCount - fiveCount;
        for (int i = 0; i < diff; i++) {
            result *= 2;
            result %= 100000000;
        }

        // 끝에 있는 0 제거
        while (result % 10 == 0) {
            result /= 10;
        }

        System.out.println(result % 10);  // 마지막 0이 아닌 자릿수
    }
}
