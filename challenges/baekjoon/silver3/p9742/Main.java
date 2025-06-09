package challenges.baekjoon.silver3.p9742;

import java.io.*;
import java.util.*;

public class Main {
    static long[] factorial = new long[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        precomputeFactorials();

        String line;
        while ((line = br.readLine()) != null) {
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            String input = parts[0];
            int k = Integer.parseInt(parts[1]);

            String result = getKthPermutation(input, k);
            System.out.println(input + " " + k + " = " + result);
        }
    }

    static void precomputeFactorials() {
        factorial[0] = 1;
        for (int i = 1; i <= 10; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    static String getKthPermutation(String str, int k) {
        List<Character> chars = new ArrayList<>();
        for (char c : str.toCharArray()) {
            chars.add(c);
        }

        int n = chars.size();
        if (k > factorial[n]) return "No permutation";

        StringBuilder sb = new StringBuilder();
        k--; // 0-based

        for (int i = n; i > 0; i--) {
            long fact = factorial[i - 1];
            int index = (int)(k / fact);
            sb.append(chars.get(index));
            chars.remove(index);
            k %= fact;
        }

        return sb.toString();
    }
}
