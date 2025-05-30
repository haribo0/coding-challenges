package challenges.baekjoon.silver3.p1051;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = sc.nextLine().toCharArray();
        }
        int maxSize = 1;

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int maxLen = Math.min(N-i,M-j);
                for(int len=1;len<maxLen;len++){
                    if (map[i][j] == map[i][j + len] &&
                        map[i][j] == map[i + len][j] &&
                        map[i][j] == map[i + len][j + len]) {
                        int area = (len + 1) * (len + 1);
                        maxSize = Math.max(maxSize, area);
                    }
                }
            }
        }
        System.out.println(maxSize);
    }
}
