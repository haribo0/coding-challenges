package challenges.baekjoon.silver2.p18870;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] origin = new int[N];
        int[] sorted = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }
        
        Arrays.sort(sorted);
        
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int num : sorted) {
            if (!map.containsKey(num)) {
                map.put(num, rank++);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : origin) {
            sb.append(map.get(num)).append(" ");
        }
        
        System.out.println(sb);
    }
}
