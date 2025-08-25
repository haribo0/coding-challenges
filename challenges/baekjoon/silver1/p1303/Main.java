package challenges.baekjoon.silver1.p1303;

import java.io.*;
import java.util.*;

public class Main {
    static int N, M;            // N: 가로(열), M: 세로(행)
    static char[][] map;
    static boolean[][] vis;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new char[M][N];
        vis = new boolean[M][N];

        for (int r = 0; r < M; r++) {
            String line = br.readLine().trim();
            for (int c = 0; c < N; c++) map[r][c] = line.charAt(c);
        }

        int white = 0, blue = 0;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (!vis[r][c]) {
                    int size = bfs(r, c, map[r][c]);
                    if (map[r][c] == 'W') white += size * size;
                    else blue += size * size; // 'B'
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    static int bfs(int sr, int sc, char color) {
        Queue<int[]> q = new ArrayDeque<>();
        vis[sr][sc] = true;
        q.add(new int[]{sr, sc});
        int cnt = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= M || nc < 0 || nc >= N) continue;
                if (vis[nr][nc] || map[nr][nc] != color) continue;
                vis[nr][nc] = true;
                q.add(new int[]{nr, nc});
                cnt++;
            }
        }
        return cnt;
    }
}
