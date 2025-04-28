package challenges.baekjoon.bronze3.p12687;

import java.util.Scanner;

interface Plan {
    int calculate(int[] callTimes);
}

class YoungsikPlan implements Plan {
    @Override
    public int calculate(int[] callTimes) {
        int total = 0;
        for (int time : callTimes) {
            total += (time / 30 + 1) * 10;
        }
        return total;
    }
}

class MinsikPlan implements Plan {
    @Override
    public int calculate(int[] callTimes) {
        int total = 0;
        for (int time : callTimes) {
            total += (time / 60 + 1) * 15;
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] callTimes = new int[N];
        for (int i = 0; i < N; i++) {
            callTimes[i] = sc.nextInt();
        }
        sc.close();

        Plan youngsik = new YoungsikPlan();
        Plan minsik = new MinsikPlan();

        int yPrice = youngsik.calculate(callTimes);
        int mPrice = minsik.calculate(callTimes);

        if (yPrice < mPrice) {
            System.out.println("Y " + yPrice);
        } else if (yPrice > mPrice) {
            System.out.println("M " + mPrice);
        } else {
            System.out.println("Y M " + yPrice);
        }
    }
}

