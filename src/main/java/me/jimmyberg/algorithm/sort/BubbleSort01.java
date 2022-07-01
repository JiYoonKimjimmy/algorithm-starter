package me.jimmyberg.algorithm.sort;

import me.jimmyberg.algorithm.common.PrintUtil;

/**
 * Bubble Sort (버블 정렬)
 * - 시간 복잡도 : O(N^2)
 * - 인접해 있는 항목 2개를 비교하여 작은 것을 앞으로 보내어 정렬한다.
 */
public class BubbleSort01 {
    public static void main(String[] args) {
        int[] sample = {1, 10, 9, 5, 8, 7, 6, 4, 3, 2};
        for (int i = 0; i < sample.length; i++) {
            for (int j = 0; j < (sample.length - 1) - i; j++) {
                if (sample[j] > sample[j + 1]) {
                    int temp = sample[j];
                    sample[j] = sample[j + 1];
                    sample[j + 1] = temp;
                }
            }
        }
        PrintUtil.printIntArray(sample);
    }
}
