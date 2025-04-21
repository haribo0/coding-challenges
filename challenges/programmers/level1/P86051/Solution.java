package challenges.programmers.level1.P86051;

import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int total = 45;
		int arraySum = Arrays.stream(numbers).distinct().sum();
        return total-arraySum;
    }
}