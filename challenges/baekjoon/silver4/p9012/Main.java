package challenges.baekjoon.silver4.p9012;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static boolean isValidParentheses(String s) {
        int balance = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else if (ch == ')') {
                balance--;
            }

            if (balance < 0) {
                return false;
            }
        }

        return balance == 0;
    }
    
    private static boolean isValidVPS(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < T; t++) {
            String line = sc.nextLine();
            if (isValidVPS(line)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
