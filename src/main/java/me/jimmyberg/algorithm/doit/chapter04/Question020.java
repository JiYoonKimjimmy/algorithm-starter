package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * 문제 020. 수 정렬하기 2 (TODO 복습 필요!)
 * - N 개의 수 배열에 대해 오름차순 정렬
 *
 * [Key Point]
 * - `병합 정렬` 활용하기!
 *  1. 배열의 크기를 2 그룹씩 나눠서 정렬한다.
 *      - 8 개 배열 -> 4 x 4 -> 2 x 2 | 2 x 2 -> ...
 *  2. 정렬이 완료된 배열을 병합하면서 다시 정렬한다.
 */
public class Question020 {
    static int[] A, temp;

    public static void main(String[] args) {
        A = new int[]{0, 5, 4, 3, 2, 1};
        temp = new int[A.length];

        CommonUtil.printIntArray(A);
        sort(1, A.length - 1);
        CommonUtil.printIntArray(A);
    }

    public static void sort(int start, int end) {
        if (end - start < 1) return;

        int mid = (start + end) / 2;
        int mid2 = start + (end - start) / 2;

        sort(start, mid);
        sort(mid + 1, end);

        // temp 배열의 현재 시작점부터 종료점까지의 배열 복사
        for (int i = start; i <= end; i++) {
            temp[i] = A[i];
        }

        // index1: Group1 시작점, index2: Group2 시작점, k: Group1 시작점
        int index1 = start, index2 = mid + 1, k = start;

        // index1 은 mid 지점까지, index2 는 end 지점까지 반복하면서,
        // 비교하여 작은 수를 A 의 새로운 자리에 저장한다.
        while (index1 <= mid && index2 <= end) {
            System.out.print("start = " + temp[start]);
            System.out.print(", end = " + temp[end]);
            System.out.print(", index1 = " + index1);
            System.out.print(", index2 = " + index2);
            System.out.print(", mid = " + mid);
            System.out.print(", mid2 = " + mid2);
            System.out.println();

            if (temp[index1] > temp[index2]) {
                A[k] = temp[index2];
                k++;
                index2++;
            } else {
                A[k] = temp[index1];
                k++;
                index1++;
            }
            System.out.print("temp = ");
            CommonUtil.printIntArray(temp);
            System.out.print("A-0 = ");
            CommonUtil.printIntArray(A);
        }

        // 나머지 배열 정리
        while (index1 <= mid) {
            A[k] = temp[index1];
            k++;
            index1++;
        }
        System.out.print("A-1 = ");
        CommonUtil.printIntArray(A);
        while (index2 <= end) {
            A[k] = temp[index2];
            k++;
            index2++;
        }
        System.out.print("A-2 = ");
        CommonUtil.printIntArray(A);
        System.out.println("================================================================================");
    }

}
