package me.jimmyberg.algorithm.doit.chapter06;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 문제 033. 카드 정렬하기
 * - 정렬된 두 개의 숫자 카드 묶음 `A`와 `B`가 있다면, 각 카드 묶음을 1개로 합칠려면 `A + B`번 비교해야한다.
 * - N 개의 숫자 카드 묶음이 있는 경우, **최소한의 비교**로 합칠 수 있는 횟수를 구하는 프로그램을 작성하시오.
 * [Key Point]
 * - 해당 문제는 **최소한의 비교**를 위해 작은 카드 묶음부터 비교해야 한다.
 * - 2개의 작은 묶음을 비교하고, 합쳐진 묶음의 크기를 다시 다음 작은 카드 묶음과 비교한다.
 * - 데이터의 삽입, 삭제, 정렬이 자주 일어나므로, **큐 Queue**를 활용하는 것이 좋다.
 * <p>
 * 1. 현재 카드 개수가 가장 작은 묶음 2개를 선택하여 합산한다.
 * 2. 합친 카드 묶음을 다시 전체 카드 묶음 속에 넣는다.
 * 3. 다시 *1*번 항목부터 카드 묶음이 1개만 남을 때까지 반복한다.
 */
public class Question033 {
    public static void main(String[] args) {
        int N = 3;
        int[] A = {10, 20, 40};
        A = Arrays.stream(A).sorted().toArray();

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : A) {
            queue.add(i);
        }
        int sum = 0;
        while (queue.size() > 1) {
            int i = queue.remove();
            int j = queue.remove();
            sum += i + j;
            queue.add(sum);
        }

        System.out.println("queue.poll() = " + queue.poll());
    }
}
