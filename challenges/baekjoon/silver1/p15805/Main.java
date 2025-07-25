package challenges.baekjoon.silver1.p15805;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] path = new int[N];

        Set<Integer> uniqueCities = new HashSet<>();
        for (int i = 0; i < N; i++) {
            path[i] = sc.nextInt();
            uniqueCities.add(path[i]);
        }

        sc.close();
        
        int K = uniqueCities.size();
        int[] parent = new int[100_001];
        Arrays.fill(parent, -2);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int city : path) {
            if (stack.isEmpty()) {
                parent[city] = -1;
                stack.push(city);
                continue;
            }

            int top = stack.peek();

            if (parent[city] == -2) {
                parent[city] = top;
                stack.push(city);
            } else {
                while (!stack.isEmpty() && stack.peek() != city) {
                    stack.pop();
                }
            }
        }

        System.out.println(K);

        int[] result = new int[K];
        for (int i = 0; i < K; i++) {
            if (parent[i] == -2) result[i] = -1;
            else result[i] = parent[i];
        }

        for (int i = 0; i < K; i++) {
            System.out.print(result[i]);
            if (i != K - 1) System.out.print(" ");
        }

    }
}
