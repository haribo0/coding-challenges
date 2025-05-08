package challenges.baekjoon.gold5.p14567;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<=N;i++){
            graph.add(new ArrayList<>());

        }

        int[] inDegree = new int[N+1];

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            graph.get(A).add(B);
            inDegree[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] semester = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                semester[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
        
            for (int next : graph.get(current)) {
                inDegree[next]--;
        
                semester[next] = Math.max(semester[next], semester[current] + 1);
        
                if (inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        
        for (int i = 1; i <= N; i++) {
            System.out.print(semester[i] + " ");
        }
        
    }
    
}
