package challenges.baekjoon.silver2.p1654;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        
        long[] arr = new long[K];
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        long left = 1;
        long right = max;
        long answer = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            long count = 0;
            for (long len : arr) {
                count += len / mid;
            }
            
            if (count >= N) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
}
