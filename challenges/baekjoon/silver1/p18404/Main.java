package challenges.baekjoon.silver1.p18404;

import java.util.*;

public class Main {
    static int N, M;
    static int[][] dist;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 체스판 크기
        M = sc.nextInt(); // 상대 말 개수

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;

        dist = new int[N][N];
        for (int[] row : dist)
            Arrays.fill(row, -1); // 초기화

        bfs(startX, startY);

        // M개의 상대편 말에 대해 거리 출력
        for (int i = 0; i < M; i++) {
            int targetX = sc.nextInt() - 1;
            int targetY = sc.nextInt() - 1;
            System.out.print(dist[targetX][targetY] + " ");
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        dist[x][y] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int cx = curr[0], cy = curr[1];

            for (int d = 0; d < 8; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cx][cy] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}
