package challenges.baekjoon.silver2.p2108;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] count = new int[8001];
        
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
            count[num + 4000]++;
            
            if (num < min) min = num;
            if (num > max) max = num;
        }
        
        Arrays.sort(arr);
        
        // 산술평균
        int mean = (int)Math.round((double) sum / N);
        
        // 중앙값
        int median = arr[N/2];
        
        // 최빈값
        int maxFreq = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] > maxFreq) {
                maxFreq = count[i];
            }
        }
        
        List<Integer> freqNums = new ArrayList<>();
        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxFreq) {
                freqNums.add(i - 4000);
            }
        }
        
        Collections.sort(freqNums);
        int mode = freqNums.size() > 1 ? freqNums.get(1) : freqNums.get(0);
        
        int range = max - min;
        
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
