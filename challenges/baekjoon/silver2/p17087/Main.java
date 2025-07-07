package challenges.baekjoon.silver2.p17087;

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int gcd = 0;
        
        for (int i = 0; i < N; i++) {
            int Ai = Integer.parseInt(st.nextToken());
            int diff = Math.abs(Ai - S);
            gcd = i == 0 ? diff : gcd(gcd, diff);
        }
        
        System.out.println(gcd);
    }
    
    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
