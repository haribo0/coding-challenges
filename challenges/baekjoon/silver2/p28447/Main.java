package challenges.baekjoon.silver2.p28447;

import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] C;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        C = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                C[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combine(new ArrayList<>(), 0);

        System.out.println(max);
    }

    static void combine(List<Integer> selected, int start) {
        if (selected.size() == K) {
            int score = 0;
            for (int i = 0; i < K; i++) {
                for (int j = i + 1; j < K; j++) {
                    int a = selected.get(i);
                    int b = selected.get(j);
                    score += C[a][b];
                }
            }
            max = Math.max(max, score);
            return;
        }

        for (int i = start; i < N; i++) {
            selected.add(i);
            combine(selected, i + 1);
            selected.remove(selected.size() - 1);
        }
    }
}

