package me.jimmyberg.coupang;

import java.util.Arrays;
import java.util.List;

/**
 * 문제. 고정점 찾기
 * - 숫자로 된 배열에서 index 와 value 가 동일한 `고정점` 를 찾는다.
 * - `고정점` 없는 경우엔, `-1` 출력
 * - O(logN) 시간 복잡도를 준수하기 위해 선형 탐색이 아닌 방식으로 탐색한다.
 * [Key Point]
 * - 분할 정복 방식으로 탐색!
 * - 결과 반환 방식 및 임계 종료 방식 고려
 * [Sample]
 * - input : -16, -15, 1, 3, 9, 6
 * - out : 3
 * - input : -16, -15, 1, 3, 9, 6
 * - out : -1
 */
public class FindFixedPoint {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-16, -15, 1, 2, 3, 6);
        System.out.println("findFixedPoint = " + findFixedPoint(list, 0, list.size()));
    }

    public static int findFixedPoint(List<Integer> list, int start, int end) {
        if (start >= end) return -1;

        int pivot = (start + end) / 2;
        int pivot_num = list.get(pivot);
        System.out.print("pivot = " + pivot);
        System.out.println(", pivot_num = " + pivot_num);

        if (pivot < pivot_num) {
            // pivot 보다 pivot_num 이 작으면, 왼쪽 탐색
            return findFixedPoint(list, start, pivot);
        } else if (pivot > pivot_num) {
            // pivot 보다 pivot_num 이 크면, 오른쪽 탐색
            return findFixedPoint(list, pivot + 1, end);
        } else {
            // 같으면, 해당 pivot 반환
            return pivot_num;
        }
    }
}
