package challenges.baekjoon.silver4.p11866;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public List<Integer> solution(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=1;i<=n;i++) queue.offer(i);
        while(!queue.isEmpty()){
            for(int i=1;i<k;i++) queue.offer(queue.poll());
            result.add(queue.poll());
        }
        return result;
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(main.solution(n, k));
    }
}
