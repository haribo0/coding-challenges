package challenges.baekjoon.silver4.p13700;

import java.util.*;

public class Main {
    static int N, S, D, F, B, K;
    static boolean[] visited;
    static Set<Integer> police = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();  // 건물 수
        S = sc.nextInt();  // 시작 지점 (금은방)
        D = sc.nextInt();  // 목적지 (집)
        F = sc.nextInt();  // 앞으로 달리는 거리
        B = sc.nextInt();  // 뒤로 달리는 거리
        K = sc.nextInt();  // 경찰서 수

        visited = new boolean[N + 1];

        for (int i = 0; i < K; i++) {
            int p = sc.nextInt();
            police.add(p);
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("BUG FOUND");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{S, 0});  // 위치, 버튼 누른 횟수
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int pos = current[0];
            int count = current[1];

            if (pos == D) return count;

            // 앞으로 달리기
            int nextF = pos + F;
            if (F > 0 && nextF <= N && !visited[nextF] && !police.contains(nextF)) {
                visited[nextF] = true;
                q.offer(new int[]{nextF, count + 1});
            }

            // 뒤로 달리기
            int nextB = pos - B;
            if (B > 0 && nextB >= 1 && !visited[nextB] && !police.contains(nextB)) {
                visited[nextB] = true;
                q.offer(new int[]{nextB, count + 1});
            }
        }

        return -1; // 도달 불가능
    }
}