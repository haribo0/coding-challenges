package challenges.baekjoon.silver2.p1411;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Map<String, Integer> patternCount = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = sc.nextLine();
            String pattern = getPattern(word);
            patternCount.put(pattern, patternCount.getOrDefault(pattern, 0) + 1);
        }

        int result = 0;
        for (int count : patternCount.values()) {
            if (count >= 2) {
                result += count * (count - 1) / 2;
            }
        }
        System.out.println(result);
    }

    static String getPattern(String word) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (char c : word.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, idx++);
            }
            sb.append(map.get(c)).append(",");
        }
        return sb.toString();
    }
}
