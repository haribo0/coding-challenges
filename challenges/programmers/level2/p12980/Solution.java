package p12980;

public class Solution {
    public int solution(int n) {
        int battery = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                battery += 1;
                n -= 1;
            }
            n /= 2;
        }

        return battery;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] testCases = {
                {5, 2},
                {6, 2},
                {5000, 5},
                {1, 1},
                {2, 1},
                {3, 2},
                {1000000000, Integer.bitCount(1000000000)} // 정답 = 이진수의 1 개수
        };

        for (int[] testCase : testCases) {
            int input = testCase[0];
            int expected = testCase[1];
            int result = sol.solution(input);
            boolean pass = result == expected;

            System.out.printf("입력: %d, 기대값: %d, 결과값: %d, %s%n",
                    input, expected, result, pass ? "✅ PASS" : "❌ FAIL");
        }
    }
}