package me.jimmyberg.algorithm.doit.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 문제 014. 절댓값 힙 구현하기 (Queue 활용 문제)
 * - 정수 배열에서 절댓값이 가장 작은 값을 출력하고, 제거한다.
 * - 우선순위 Queue 를 활용하여 정렬 기준을 정하고, 절댓값 작은 순서로 정렬한다.
 * - 입력 정수 0 인 경우, 절댓값 작은 수를 출력한다.
 */
public class Question014 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            int f = Math.abs(o1);
            int s = Math.abs(o2);
            if (f == s) {
                return o1 > o2 ? 1 : 0;
            } else {
                return f - s;
            }
        });

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            if (x == 0) {
                if (queue.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(queue.poll());
                }
            } else {
                queue.add(x);
            }
        }

        result.forEach(System.out::println);
    }
}
