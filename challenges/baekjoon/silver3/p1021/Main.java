package challenges.baekjoon.silver3.p1021;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = sc.nextInt();
        }
            
        sc.close();


        int totalMoves = 0;

        for (int i = 0; i < M; i++) {
            int target = targets[i];
            int idx = deque.indexOf(target);

            int halfIndex;
            if (deque.size() % 2 == 0) {
                halfIndex = deque.size() / 2 - 1;
            } else {
                halfIndex = deque.size() / 2;
            }

            if (idx <= halfIndex) {
                // 왼쪽으로 회전
                for (int j = 0; j < idx; j++) {
                    deque.addLast(deque.pollFirst());
                    totalMoves++;
                }
            } else {
                // 오른쪽으로 회전
                for (int j = 0; j < deque.size() - idx; j++) {
                    deque.addFirst(deque.pollLast());
                    totalMoves++;
                }
            }

            // 첫 번째 요소 제거
            deque.pollFirst();
        }

        System.out.println(totalMoves);

    }
}
