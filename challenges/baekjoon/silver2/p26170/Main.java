package challenges.baekjoon.silver2.p26170;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[5][5];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class State {
        int r, c, apple, step;
        int bitmask;

        State(int r, int c, int apple, int step, int bitmask) {
            this.r = r;
            this.c = c;
            this.apple = apple;
            this.step = step;
            this.bitmask = bitmask;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sr = Integer.parseInt(st.nextToken());
        int sc = Integer.parseInt(st.nextToken());

        System.out.println(bfs(sr, sc));
    }

    static int bfs(int sr, int sc) {
        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int startIdx = sr * 5 + sc;
        int startBitmask = (1 << startIdx);
        queue.add(new State(sr, sc, 0, 0, startBitmask));
        visited.add(sr + "," + sc + ",0," + startBitmask);

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.apple == 3) {
                return cur.step;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5) continue;

                int idx = nr * 5 + nc;
                if (((cur.bitmask >> idx) & 1) == 1) continue;
                if (board[nr][nc] == -1) continue;

                int newApple = cur.apple;
                if (board[nr][nc] == 1) newApple++;

                int newBitmask = cur.bitmask | (1 << (cur.r * 5 + cur.c));
                String key = nr + "," + nc + "," + newApple + "," + newBitmask;
                if (visited.contains(key)) continue;
                visited.add(key);
                queue.add(new State(nr, nc, newApple, cur.step + 1, newBitmask));
            }
        }
        return -1;
    }
}
