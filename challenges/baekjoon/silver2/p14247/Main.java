package challenges.baekjoon.silver2.p14247;

import java.util.*;

public class Main {
    static class Tree implements Comparable<Tree> {
        int h, a;
        public Tree(int h, int a) {
            this.h = h;
            this.a = a;
        }

        public int compareTo(Tree o) {
            return this.a - o.a;  // 성장속도 오름차순
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Tree[] trees = new Tree[n];

        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            trees[i] = new Tree(h, 0);
        }

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            trees[i].a = a;
        }

        Arrays.sort(trees);

        long total = 0;
        for (int day = 0; day < n; day++) {
            Tree t = trees[day];
            total += (long)t.h + (long)t.a * day;
        }

        System.out.println(total);
    }
}
