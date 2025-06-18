package challenges.baekjoon.silver2.p11060;

import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(bfs(N));
    }

    static int bfs(int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});  // {현재 index, 점프 횟수}
        visited[0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int pos = current[0];
            int jumps = current[1];

            // 도착
            if (pos == N - 1) {
                return jumps;
            }

            // 다음 점프
            for (int i = 1; i <= arr[pos]; i++) {
                int next = pos + i;
                if (next < N && !visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, jumps + 1});
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }
}
