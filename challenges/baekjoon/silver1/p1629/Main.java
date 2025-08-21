package challenges.baekjoon.silver1.p1629;

import java.io.*;
import java.util.*;

public class Main {
    static long modPow(long a, long b, long m) {
        if (m == 1) return 0;
        a %= m;
        long res = 1 % m;

        while (b > 0) {
            if ((b & 1L) == 1L) res = (res * a) % m; // 현재 비트가 1이면 곱하기
            a = (a * a) % m;                         // 밑을 제곱
            b >>= 1;                                 // 지수 절반으로
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(modPow(A, B, C));
    }
}

