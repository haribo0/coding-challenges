package challenges.baekjoon.silver1.p1946;

import java.io.*;
import java.util.*;

public class Main {
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        FastScanner(InputStream is) { in = is; }
        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }
        int nextInt() throws IOException {
            int c, s = 1, x = 0;
            do { c = read(); } while (c <= ' ');        // skip spaces
            if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + (c - '0'); c = read(); }
            return x * s;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int T = fs.nextInt();
        for (int tc = 0; tc < T; tc++) {
            int N = fs.nextInt();
            int[][] a = new int[N][2];
            for (int i = 0; i < N; i++) {
                a[i][0] = fs.nextInt(); // 서류
                a[i][1] = fs.nextInt(); // 면접
            }

            Arrays.sort(a, Comparator.comparingInt(p -> p[0])); // 서류 오름차순

            int cnt = 0;
            int bestInterview = Integer.MAX_VALUE;
            for (int i = 0; i < N; i++) {
                if (a[i][1] < bestInterview) { // 면접이 지금까지의 최소보다 좋으면 선발
                    cnt++;
                    bestInterview = a[i][1];
                }
            }
            out.append(cnt).append('\n');
        }
        System.out.print(out);
    }
}
