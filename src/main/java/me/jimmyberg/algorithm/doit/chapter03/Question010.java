package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 문제 010. 최솟값 찾기
 * - N 개의 수의 배열에서 지정된 범위 안에 최솟값 구하기
 * - N : 12 개
 * - L : 3
 * - 범위 규칙 : i - L + 1 (i - 3 + 1)
 * - 12 개의 수 배열 : 1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6
 * - 최솟값 출력 결과 : 1 1 1 2 2 3 2 2 3 3 3 2
 *
 * [Solution]
 * - !! deque 활용 !!
 * 1. 현재 deque 의 마지막 node 에 대한 value 가 현재 입력 node 의 value 보다 크다면 삭제 처리
 * 2. 현재 node 를 deque 의 last 추가
 * 3. 현재 deque 첫 번째 node 가 범위 규칙에 벗어났는지 확인 후, 삭제 처리
 * 4. deque 첫 번째 node 의 value 를 출력
 */
public class Question010 {
    public static void main(String[] args) {
        int N = 12;
        int L = 3;
        int[] A = {1, 5, 2, 3, 6, 2, 3, 7, 3, 5, 2, 6};

        Deque<Node> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            Node now = new Node(i, A[i]);

            if (!deque.isEmpty() && deque.getLast().value > now.value) {
                // deque 마지막 value 가 현재 value 보다 큰 경우, remove 처리
                deque.removeLast();
            }

            // 현재 node 추가
            deque.add(now);

            if (deque.getFirst().index < (i - L  + 1)) {
                // deque 의 첫 번째 node 의 index 가 지정한 범위를 넘어간 경우, remove 처리
                deque.removeFirst();
            }

            // 현재 deque 첫 번째 node 의 value 출력
            System.out.print(deque.getFirst().value + " ");
        }
    }

    static class Node {
        public int index;
        public int value;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
