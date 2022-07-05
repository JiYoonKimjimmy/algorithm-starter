package me.jimmyberg.algorithm.sort;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * Quick Sort (퀵 정렬)
 * - 시간 복잡도 : O(N * logN)
 * - Pivot 을 기준으로 왼쪽에서는 Pivot 보다 큰 항목을 찾고,
 * - 오른쪽에서는 Pivot 보다 작은 항목을 찾는 후에, 양 쪽의 항목을 서로 Swap 반복
 * - 왼쪽과 오른쪽 Pivot 기준이 교차되는 순간, Pivot 과 작은 항목를 Swap
 */
public class QuickSort02 {

    public static void sort(int[] data, int start, int end) {
        if (start >= end) return;

        int i = start + 1, j = end;

        while (i <= j) {
            while (i <= end && data[i] <= data[start]) {
                // i (-->) 오른쪽으로 이동하면서, pivot 값보다 큰 값을 검색
                i++;
            }

            while (j > start && data[j] >= data[start]) {
                // j (<--) 왼쪽으로 이동하면서, pivot 값보다 작은 값을 검색
                j--;
            }

            if (i > j) {
                // 오른쪽으로 이동하던 i 가 j 를 교차할 때, 작은 값과 pivot 값을 swap
                CommonUtil.swap(data, j, start);
            } else {
                // 교차되지 않은 경우, 각각 검색된 큰 값과 작은 값을 swap
                CommonUtil.swap(data, i, j);
            }
        }

        // 정렬이 한번 이뤄진 후
        // start 위치부터 j - 1 만큼 왼쪽 partition 정렬
        sort(data, start, j - 1);
        // j + 1 만큼 오른쪽 partition 정렬
        sort(data, j + 1, end);
    }

    public static void main(String[] args) {
        int[] sample = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

        sort(sample, 0, sample.length - 1);

        CommonUtil.printIntArray(sample);
    }
}
