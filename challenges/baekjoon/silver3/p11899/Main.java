package challenges.baekjoon.silver3.p11899;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();

        int openCount = 0;
        int addLeft = 0;

        for(char ch : s.toCharArray())
            if(ch == '('){
                openCount += 1;
            }
            else if (ch == ')'){
                if(openCount > 0)
                    openCount -= 1;
                else
                    addLeft += 1;
            }

        int addRight = openCount;

        System.out.println(addLeft + addRight);

    }
}
