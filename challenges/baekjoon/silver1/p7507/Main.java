package challenges.baekjoon.silver1.p7507;

import java.util.*;

public class Main {
    static class Match {
        int start, end;

        Match(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int m = sc.nextInt();
            Map<Integer, List<Match>> dayMap = new HashMap<>();

            for (int i = 0; i < m; i++) {
                int d = sc.nextInt();
                int s = sc.nextInt();
                int e = sc.nextInt();

                dayMap.computeIfAbsent(d, k -> new ArrayList<>()).add(new Match(s, e));
            }

            int total = 0;

            for (int day : dayMap.keySet()) {
                List<Match> list = dayMap.get(day);
                // 종료 시간 기준 정렬
                list.sort(Comparator.comparingInt(a -> a.end));

                int cnt = 0;
                int lastEnd = 0;

                for (Match match : list) {
                    if (match.start >= lastEnd) {
                        cnt++;
                        lastEnd = match.end;
                    }
                }

                total += cnt;
            }

            sc.close();
            System.out.println("Scenario #" + tc + ":");
            System.out.println(total);
            if (tc < T) System.out.println();
        }
    }
}
