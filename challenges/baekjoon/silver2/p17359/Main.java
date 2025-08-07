package challenges.baekjoon.silver2.p17359;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static String[] bulbs;
    static boolean[] visited;
    static int minChanges = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        bulbs = new String[N];

        for (int i = 0; i < N; i++) {
            bulbs[i] = br.readLine();
        }

        visited = new boolean[N];
        permute(new ArrayList<>());

        System.out.println(minChanges);
    }

    // 순열 생성
    static void permute(List<Integer> order) {
        if (order.size() == N) {
            int totalChanges = 0;
            String prev = null;

            for (int idx = 0; idx < N; idx++) {
                String current = bulbs[order.get(idx)];
                totalChanges += countChanges(current);

                if (prev != null) {
                    // 경계 변화 체크
                    if (prev.charAt(prev.length() - 1) != current.charAt(0)) {
                        totalChanges++;
                    }
                }

                prev = current;
            }

            minChanges = Math.min(minChanges, totalChanges);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(i);
                permute(order);
                order.remove(order.size() - 1);
                visited[i] = false;
            }
        }
    }

    // 문자열 내에서 01, 10 변화 횟수 세기
    static int countChanges(String s) {
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                cnt++;
            }
        }
        return cnt;
    }
}
