package me.jimmyberg.algorithm.sort;

/**
 * Selection Sort (선택 정렬)
 * - 시간 복잡도 : N + (N + 1) = O(N^2)
 * - index `0` 부터 모든 list 를 순차적으로 loop 하면서 작은 것을 찾는다.
 * - 작은 것을 순차적으로 앞으로 swap 하여 정렬한다.
 */
public class SelectionSort01 {

    public static void main(String[] args) {
        int[] sample = {1, 10, 5, 8, 7, 6, 4, 3, 2, 9};
        int temp, index = 0;

        for (int i = 0; i < sample.length; i++) {
            System.out.println(i + " : " + sample[i]);
            int min = 99;
            for (int j = i ; j < sample.length; j++) {
                if (min > sample[j]) {
                    min = sample[j];
                    index = j;
                }
            }
            temp = sample[i];
            sample[i] = sample[index];
            sample[index] = temp;
        }

        for (int i : sample) {
            System.out.print(i + " ");
        }

    }

}
