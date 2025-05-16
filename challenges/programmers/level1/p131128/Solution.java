package challenges.programmers.level1.p131128;

public class Solution {
    public static String solution(String X, String Y){

        int[] countX = new int[10];
        int[] countY = new int[10];

        for (char ch : X.toCharArray()) {
            countX[ch - '0']++;
        }
        for (char ch : Y.toCharArray()) {
            countY[ch - '0']++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]);
            for (int j = 0; j < common; j++) {
                result.append(i);
            }
        }
        if (result.length() == 0) {
            return "-1";
        } else if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result.toString();
        }
        
    }

    public static void runTest(String X, String Y, String expected) {
        String result = solution(X, Y);
        boolean passed = result.equals(expected);

        System.out.println("X = " + X + ", Y = " + Y);
        System.out.println("Expected: " + expected);
        System.out.println("Result:   " + result);
        System.out.println("Test:     " + (passed ? "PASS ✅" : "FAIL ❌"));
        System.out.println("----------");
    }

    public static void main(String[] args) {
        runTest("100", "2345", "-1");
        runTest("100", "203045", "0");
        runTest("100", "123450", "10");
        runTest("12321", "42531", "321");
        runTest("5525", "1255", "552");
    }

}
