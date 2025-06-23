package challenges.baekjoon.silver2.P27968;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] prefix = new long[M + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            prefix[i] = prefix[i - 1] + Long.parseLong(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            long want = Long.parseLong(br.readLine());

            int l = 1, r = M, ans = -1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (prefix[mid] >= want) {
                    ans = mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            if (ans == -1) sb.append("Go away!\n");
            else sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}
