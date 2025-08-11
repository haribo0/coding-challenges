package challenges.baekjoon.silver2.p3085;

import java.io.*;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new char[N][N];
        for (int i = 0; i < N; i++) board[i] = br.readLine().trim().toCharArray();

        int answer = computeMax(); // 스왑을 안 해도 더 클 수 있으니 초기값으로 반영

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 오른쪽과 스왑
                if (j + 1 < N && board[i][j] != board[i][j + 1]) {
                    swap(i, j, i, j + 1);
                    answer = Math.max(answer, computeMax());
                    swap(i, j, i, j + 1);
                }
                // 아래와 스왑
                if (i + 1 < N && board[i][j] != board[i + 1][j]) {
                    swap(i, j, i + 1, j);
                    answer = Math.max(answer, computeMax());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(answer);
    }

    // 보드 전체에서 (모든 행, 모든 열) 최장 연속 같은 색 길이
    static int computeMax() {
        int best = 1;

        // 행 검사
        for (int i = 0; i < N; i++) {
            int cur = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) cur++;
                else {
                    best = Math.max(best, cur);
                    cur = 1;
                }
            }
            best = Math.max(best, cur);
        }

        // 열 검사
        for (int j = 0; j < N; j++) {
            int cur = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) cur++;
                else {
                    best = Math.max(best, cur);
                    cur = 1;
                }
            }
            best = Math.max(best, cur);
        }

        return best;
    }

    static void swap(int r1, int c1, int r2, int c2) {
        char t = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = t;
    }
}
