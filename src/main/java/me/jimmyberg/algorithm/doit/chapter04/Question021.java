package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * 문제 021. 버블 소트 프로그램 2
 * - `버블 정렬` 할 때 swap 이 총 몇번 발생하는지 구하기
 *
 * [Key Point]
 * - `병합 정렬` 에서 두 그룹을 병합할 때, `버블 정렬` 의 swap! 이 일어나기 때문에,
 * - `버블 정렬` 이 아닌 `병합 정렬` 활용!
 * - [중요!] `병합 정렬` 에서 두 그룹이 병합한다는 의미는, Group2 가 앞으로 정렬되는 순간을 의미한다!
 * - [중요!] index1 과 index2 가 이동하여 새로 정렬되는 "거리"를 `버블 정렬` swap! 일어나는 횟수로 계산한다!
 */
public class Question021 {
    static int[] A, T;
    static int COUNT = 0;
    public static void main(String[] args) {
        A = new int[]{0, 3, 2, 8, 1, 7, 4, 5, 6};
        T = new int[A.length];

        CommonUtil.printIntArray(A);
        mergeSort(0, A.length - 1);
        CommonUtil.printIntArray(A);
        System.out.println("COUNT = " + COUNT);
    }

    static void mergeSort(int start, int end) {
        if (end - start < 1) return;

        int mid = start + (end - start) / 2;

        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        System.out.print("S = " + start);
        System.out.print(", E = " + end);
        System.out.println(", M = " + mid);

        if (end + 1 - start >= 0) System.arraycopy(A, start, T, start, end + 1 - start);

        int index1 = start, index2 = mid + 1, point = start;

        while (index1 <= mid && index2 <= end) {
            if (T[index1] < T[index2]) {
                System.out.print("point = " + point);
                System.out.println(", index1 = " + index1);
                A[point++] = T[index1++];
            } else {
                System.out.print("point = " + point);
                System.out.println(", index2 = " + index2);
                COUNT += index2 - point;
                A[point++] = T[index2++];
            }
        }

        while (index1 <= mid) {
            A[point++] = T[index1++];
        }

        while (index2 <= end) {
            A[point++] = T[index2++];
        }
    }
}
