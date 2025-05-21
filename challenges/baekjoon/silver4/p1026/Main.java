package challenges.baekjoon.silver4.p1026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        int[] B = new int[N];

        for (int i = 0; i < N; i++) A[i] = sc.nextInt();
        for (int i = 0; i < N; i++) B[i] = sc.nextInt();

        Arrays.sort(A);
        Integer[] indices = new Integer[N];
        for (int i = 0; i < N; i++) indices[i]=i;

        Arrays.sort(indices, (i,j)->Integer.compare(B[j],B[i]));
        
        int[] sortedA = new int[N];

        for(int i=0;i<N;i++){
            sortedA[indices[i]] = A[i];
        }
        
        int result = 0;
        for(int i=0;i<N;i++){
            result += (sortedA[i]*B[i]);
        }

        System.out.println(result);

    }
}
