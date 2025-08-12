package challenges.baekjoon.silver2.p14713;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        List<Deque<String>> birds = new ArrayList<>(N);
        Map<String, Integer> owner = new HashMap<>(); // 단어 -> 어떤 앵무새(문장)인지
        int totalWords = 0;

        for (int i = 0; i < N; i++) {
            Deque<String> q = new ArrayDeque<>();
            String line = br.readLine().trim();
            if (!line.isEmpty()) {
                for (String w : line.split(" ")) {
                    q.addLast(w);
                    owner.put(w, i);
                    totalWords++;
                }
            }
            birds.add(q);
        }

        String[] L = br.readLine().trim().split(" ");
        // 모든 앵무새가 끝까지 말했으니, 단어 수가 정확히 같아야 함
        if (L.length != totalWords) {
            System.out.println("Impossible");
            return;
        }

        for (String w : L) {
            Integer idx = owner.get(w);
            if (idx == null) { // 그런 단어가 애초에 없음
                System.out.println("Impossible");
                return;
            }
            Deque<String> q = birds.get(idx);
            if (q.isEmpty() || !q.peekFirst().equals(w)) { // 순서 위반
                System.out.println("Impossible");
                return;
            }
            q.pollFirst();
        }

        // 전부 소비되어야 함
        for (Deque<String> q : birds) {
            if (!q.isEmpty()) {
                System.out.println("Impossible");
                return;
            }
        }
        System.out.println("Possible");
    }
}
