package challenges.programmers.level1.p64061;

import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        
        for(int move:moves) {
            for(int[] row : board) {
                if(row[move-1]>0) {
                    if(!stack.isEmpty() && stack.peek()==row[move-1]) {
                        stack.pop();
                        answer+=2;
                    } else {
                        stack.push(row[move-1]);
                    }
                    row[move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}