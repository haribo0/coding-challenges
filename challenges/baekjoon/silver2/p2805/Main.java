package challenges.baekjoon.silver2.p2805;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        
        int max = 0;
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > max) {
                max = trees[i];
            }
        }
        
        long low = 0;
        long high = max;
        long answer = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            
            long total = 0;
            for (int h : trees) {
                if (h > mid) {
                    total += h - mid;
                }
            }
            
            if (total >= M) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}
