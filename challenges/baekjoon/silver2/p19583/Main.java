package challenges.baekjoon.silver2.p19583;

import java.io.*;
import java.util.*;

public class Main {
    static int toMin(String hhmm) {
        String[] p = hhmm.split(":");
        return Integer.parseInt(p[0]) * 60 + Integer.parseInt(p[1]);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = toMin(st.nextToken());
        int E = toMin(st.nextToken());
        int Q = toMin(st.nextToken());

        Set<String> entered = new HashSet<>();
        Set<String> counted = new HashSet<>();
        int answer = 0;

        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) continue;      // 안전장치
            st = new StringTokenizer(line);
            String tStr = st.nextToken();
            String name = st.nextToken();
            int t = toMin(tStr);

            if (t <= S) {                      // 입장 확인
                entered.add(name);
            } else if (t >= E && t <= Q) {     // 퇴장 확인
                if (entered.contains(name) && counted.add(name)) {
                    answer++;
                }
            } else if (t > Q) {                // 이후 전부 다른 방송
                break;
            }
        }
        System.out.println(answer);
    }
}
