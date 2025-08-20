package challenges.baekjoon.silver1.p1342;

import java.io.*;
import java.util.*;

public class Main {
    static int[] cnt = new int[26];
    static int n;
    static long answer = 0;

    static void dfs(int depth, int last) {
        if (depth == n) { // 전부 배치 완료
            answer++;
            return;
        }
        for (int c = 0; c < 26; c++) {
            if (cnt[c] == 0) continue;   // 남은 문자가 없음
            if (c == last) continue;     // 인접 동일 금지
            cnt[c]--;
            dfs(depth + 1, c);
            cnt[c]++;                    // 복구
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        n = s.length();
        for (char ch : s.toCharArray()) cnt[ch - 'a']++;
        dfs(0, -1);                      // 시작은 직전 문자가 없으므로 -1
        System.out.println(answer);
    }
}
