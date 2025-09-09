package challenges.baekjoon.silver2.p2796;

import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static char[] src;
    static char[] ans;
    static boolean found = false;
    static int needOpen;     // G에 배정해야 할 '(' 개수
    static int[] sufG;       // i..끝까지의 G 개수 누적(접미)
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        String s = br.readLine().trim();
        src = s.toCharArray();
        ans = s.toCharArray();

        // 전체에서 '(' 개수는 최종적으로 정확히 N/2 여야 함
        int existingOpen = 0, totalG = 0;
        for (char c : src) {
            if (c == '(') existingOpen++;
            else if (c == 'G') totalG++;
        }
        needOpen = N / 2 - existingOpen; // G에서 '(' 로 채워야 하는 개수

        // 접미 G 카운트(가지치기용)
        sufG = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            sufG[i] = sufG[i + 1] + (src[i] == 'G' ? 1 : 0);
        }

        // 문제에서 "복구 가능한 입력만 주어진다"지만, 안전 가드
        if (N % 2 == 1 || needOpen < 0 || needOpen > totalG) {
            // 이 경우는 입력 보장에 어긋나므로, 그대로 출력(혹은 종료)
            System.out.println(s);
            return;
        }

        dfs(0, 0, 0);
        // found는 항상 true가 되도록 입력이 주어짐
        // (안전하게 백업 출력)
        if (!found) System.out.println(new String(ans));
    }

    // i: 현재 인덱스, bal: 현재 밸런스(열림-닫힘), usedOpen: G에 배정한 '(' 개수
    static void dfs(int i, int bal, int usedOpen) {
        if (found) return;

        // 가지치기: 밸런스 음수 금지, 남은 칸으로 닫을 수 있어야 함
        if (bal < 0) return;
        if (bal > N - i) return;

        // 가지치기: 남은 G로 필요한 '(' 를 채울 수 있어야 함
        int remainG = sufG[i];
        if (usedOpen > needOpen) return;
        if (usedOpen + remainG < needOpen) return;

        if (i == N) {
            if (bal == 0 && usedOpen == needOpen) {
                System.out.println(new String(ans));
                found = true;
            }
            return;
        }

        char c = src[i];
        if (c == '(' || c == ')') {
            ans[i] = c;
            dfs(i + 1, bal + (c == '(' ? 1 : -1), usedOpen);
        } else { // 'G'인 경우: '(' 먼저 시도 후 ')' 시도
            if (usedOpen < needOpen) {
                ans[i] = '(';
                dfs(i + 1, bal + 1, usedOpen + 1);
                if (found) return;
            }
            ans[i] = ')';
            dfs(i + 1, bal - 1, usedOpen);
        }
    }
}
