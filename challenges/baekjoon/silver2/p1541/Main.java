package challenges.baekjoon.silver2.p1541;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String exp = sc.next();

        String[] minusSplit = exp.split("-");

        int result = sum(minusSplit[0]);

        for (int i = 1; i < minusSplit.length; i++) {
            result -= sum(minusSplit[i]);
        }

        System.out.println(result);
    }

    static int sum(String s) {
        String[] plusSplit = s.split("\\+");
        int total = 0;
        for (String part : plusSplit) {
            total += Integer.parseInt(part);
        }
        return total;
    }
}
