package challenges.baekjoon.silver2.p1780;

import java.util.*;
import java.io.*;

public class Main {
    static int[][] paper;
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countPaper(0, 0, N);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    static void countPaper(int row, int col, int size) {
        if (check(row, col, size)) {
            int value = paper[row][col];
            if (value == -1) minusOne++;
            else if (value == 0) zero++;
            else if (value == 1) one++;
            return;
        }

        int newSize = size / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                countPaper(row + i * newSize, col + j * newSize, newSize);
            }
        }
    }

    static boolean check(int row, int col, int size) {
        int first = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (paper[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
