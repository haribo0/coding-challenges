package challenges.baekjoon.silver1.p1713;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());      // 사진틀 개수
        int M = Integer.parseInt(br.readLine().trim());      // 총 추천 횟수

        boolean[] in = new boolean[101];   // 현재 프레임에 있는가
        int[] cnt = new int[101];          // 현재 프레임에서의 추천 수
        int[] when = new int[101];         // 게시된 시각(추천 처리 인덱스)
        int frames = 0;

        StringTokenizer st = null;
        for (int t = 0; t < M; t++) {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) break;
                st = new StringTokenizer(line);
            }
            int x = Integer.parseInt(st.nextToken()); // 추천받은 학생

            if (in[x]) {                // 이미 게시됨 → 추천 수 증가
                cnt[x]++;
                continue;
            }

            if (frames < N) {           // 빈 프레임 있음 → 바로 게시
                in[x] = true;
                cnt[x] = 1;
                when[x] = t;
                frames++;
            } else {                    // 꽉 참 → 최소 추천 & 가장 오래된 학생 제거
                int removeId = -1;
                int minCnt = Integer.MAX_VALUE;
                int minWhen = Integer.MAX_VALUE;

                for (int s = 1; s <= 100; s++) {
                    if (!in[s]) continue;
                    if (cnt[s] < minCnt || (cnt[s] == minCnt && when[s] < minWhen)) {
                        minCnt = cnt[s];
                        minWhen = when[s];
                        removeId = s;
                    }
                }

                // 제거 (해당 학생의 추천 수 0으로)
                in[removeId] = false;
                cnt[removeId] = 0;
                when[removeId] = 0;

                // 새 학생 게시
                in[x] = true;
                cnt[x] = 1;
                when[x] = t;
            }
        }

        StringBuilder out = new StringBuilder();
        for (int s = 1; s <= 100; s++) {
            if (in[s]) out.append(s).append(' ');
        }
        if (out.length() > 0) out.setLength(out.length() - 1);
        System.out.println(out.toString());
    }
}
