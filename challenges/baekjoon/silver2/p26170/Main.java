package challenges.baekjoon.silver2.p26170;

import java.util.*;

public class Main {
    static final int N = 5;
    static int[][] board = new int[N][N];
    static boolean[][][][] visited = new boolean[N][N][4][1 << 25]; // 최악 대비하면 비트마스크는 따로 처리하는 게 더 좋음
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class State {
        int r, c, apple, steps;
        boolean[][] block;

        public State(int r, int c, int apple, int steps, boolean[][] block) {
            this.r = r;
            this.c = c;
            this.apple = apple;
            this.steps = steps;
            this.block = new boolean[N][N];
            for (int i = 0; i < N; i++)
                this.block[i] = block[i].clone();
        }
    }

    public static int bfs(int sr, int sc) {
        Queue<State> q = new LinkedList<>();
        boolean[][] initBlock = new boolean[N][N];
        initBlock[sr][sc] = true;
        q.offer(new State(sr, sc, 0, 0, initBlock));

        while (!q.isEmpty()) {
            State cur = q.poll();
            if (cur.apple == 3) return cur.steps;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                if (board[nr][nc] == -1 || cur.block[nr][nc]) continue;

                int newApple = cur.apple + (board[nr][nc] == 1 ? 1 : 0);
                boolean[][] newBlock = cur.block;
                newBlock[cur.r][cur.c] = true;

                q.offer(new State(nr, nc, newApple, cur.steps + 1, newBlock));
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                board[i][j] = sc.nextInt();
        int sr = sc.nextInt();
        int sc_ = sc.nextInt();

        System.out.println(bfs(sr, sc_));
    }
}
