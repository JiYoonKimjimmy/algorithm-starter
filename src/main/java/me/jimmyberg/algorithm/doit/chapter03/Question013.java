package me.jimmyberg.algorithm.doit.chapter03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제 013. 카드 게임 (Queue 활용 문제)
 * - 1 ~ N 번까지의 N 장의 카드를 다음 순서대로 동작했을 때 가장 마지막으로 남는 카드의 번호 구하기
 *
 * [동작 순서]
 * 1. 가장 위에 있는 카드를 버린다.
 * 2. 다음 카드를 맨 아래로 옮긴다.
 * - 1 ~ 2 번 순서를 반복하였을 때, 마지막에 남는 카드의 Index 출력
 */
public class Question013 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(sc.nextInt());
        }

        while (queue.size() != 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());
    }
}
