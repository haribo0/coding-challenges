package challenges.programmers.level1.p42746;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                                    .mapToObj(String::valueOf)
                                    .toArray(String[]::new);
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        String result = String.join("", strNumbers);
        if (result.startsWith("0")) return "0";
        return result;
    }
}