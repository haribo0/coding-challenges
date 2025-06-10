package challenges.baekjoon.silver3.p16922;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();  // 사용할 문자 개수

        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i <= N; i++) {            // I 개수
            for (int v = 0; v <= N - i; v++) {    // V 개수
                for (int x = 0; x <= N - i - v; x++) {  // X 개수
                    int l = N - i - v - x;        // L 개수

                    int sum = i * 1 + v * 5 + x * 10 + l * 50;
                    resultSet.add(sum);
                }
            }
        }

        System.out.println(resultSet.size());
    }
}
