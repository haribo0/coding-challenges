package challenges.baekjoon.silver1.p1189;

import java.util.Scanner;

public class Main {
    static int R, C, K, answer = 0;
    static char[][] map;
    static boolean[][] visited;

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        K = sc.nextInt();
        sc.nextLine();
        sc.close();

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        visited[R - 1][0] = true; // 시작점 방문
        dfs(R - 1, 0, 1); // 현재 좌표, 이동 거리

        System.out.println(answer);
    }

    static void dfs(int x, int y, int dist) {
        if (x == 0 && y == C - 1) { // 도착지
            if (dist == K) answer++;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C &&
                !visited[nx][ny] && map[nx][ny] != 'T') {
                
                visited[nx][ny] = true;
                dfs(nx, ny, dist + 1);
                visited[nx][ny] = false;
            }
        }
    }
}
