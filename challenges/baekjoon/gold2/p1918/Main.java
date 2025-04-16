package challenges.baekjoon.gold2.p1918;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0; // '('일 때
    }
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String infix = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(char ch : infix.toCharArray()){
            if(Character.isLetter(ch)){ // 문자
                sb.append(ch);
            }else if(ch=='('){  // 괄호 열기
                stack.push(ch);
            }else if(ch==')'){  // 괄호 닫기 
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
            }else{  // 연산자
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb.toString());
    }
}
