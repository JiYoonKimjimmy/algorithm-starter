package me.jimmyberg.algorithm.basic.sort;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * Insertion Sort (삽입 정렬)
 * - 시간 복잡도 : O(N^2)
 * - 선택된 항목보다 오른쪽에 있는 항목이 작으면 Swap
 */
public class InsertionSort01 {
    public static void main(String[] args) {
        int[] sample = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        for (int i = 0; i < sample.length - 1; i++) {
            int j = i;
            while (j >= 0 && sample[j] > sample[j + 1]) {
                int temp = sample[j];
                sample[j] = sample[j + 1];
                sample[j + 1] = temp;
                j--;
            }
        }
        CommonUtil.printIntArray(sample);
    }
}
