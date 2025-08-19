package challenges.baekjoon.silver1.p1283;

import java.io.*;

public class Main {
    static int idxOf(char ch) {
        ch = Character.toLowerCase(ch);
        if ('a' <= ch && ch <= 'z') return ch - 'a';
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        boolean[] used = new boolean[26];
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int pick = -1;

            // 1) 각 단어의 첫 글자 우선
            for (int j = 0; j < s.length(); j++) {
                if (j == 0 || s.charAt(j - 1) == ' ') {
                    int k = idxOf(s.charAt(j));
                    if (k != -1 && !used[k]) {
                        used[k] = true;
                        pick = j;
                        break;
                    }
                }
            }

            // 2) 전체 문자열에서 첫 미사용 글자
            if (pick == -1) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == ' ') continue;
                    int k = idxOf(s.charAt(j));
                    if (k != -1 && !used[k]) {
                        used[k] = true;
                        pick = j;
                        break;
                    }
                }
            }

            if (pick == -1) {
                out.append(s).append('\n');
            } else {
                StringBuilder line = new StringBuilder();
                for (int j = 0; j < s.length(); j++) {
                    if (j == pick) {
                        line.append('[').append(s.charAt(j)).append(']');
                    } else {
                        line.append(s.charAt(j));
                    }
                }
                out.append(line).append('\n');
            }
        }

        System.out.print(out.toString());
    }
}

