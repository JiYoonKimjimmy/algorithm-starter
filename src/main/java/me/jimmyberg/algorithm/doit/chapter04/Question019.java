package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * 문제 019. K 번째 수 구하기 (TODO 복습 필요!)
 * - N 개의 수를 오름차순 정렬하고, K 번째의 수 구하기
 *
 * [Key Point]
 * - `퀵 정렬` 활용하기!
 *  1. `퀵 정렬` 은 `투 포인터` 와 pivot 을 설정하여 집합 분리하여 정렬한다.
 *      1.1. start < pivot 인 경우, start++ 이동
 *      1.2. end > pivot 인 경우, end-- 이동
 *      1.3. start > pivot & end < pivot 인 경우, start 와 end 를 swap! 하고, start++, end-- 이동
 *      1.4. start == end 될 때까지 1.1 ~ 1.3 과정 반복
 *      1.5. start == end 인 경우, start < pivot 이면 start + 1 위치에 pivot 를 swap! 하고, start > pivot 이면 start - 1 위치에 pivot 를 swap!
 *  2. 분리 집합이 1개 이하가 될 때까지 1.1 ~ 1.5 과정을 반복한다.
 */
public class Question019 {
    public static void main(String[] args) {
        int N = 5;
        int K = 3;
        int[] A = {4, 1, 2, 3, 5};

        quickSort(A, 0, N - 1, K - 1);

        CommonUtil.printIntArray(A);
        System.out.println(A[K - 1]);
    }

    public static void quickSort(int[] A, int S, int E, int K) {
        if (S < E) {
            int P = partition(A, S, E);
            if (K < P) {
                quickSort(A, S, P - 1, K);
            } else if (K != P) {
                quickSort(A, P + 1, E, K);
            }
        }
    }

    public static int partition(int[] A, int S, int E) {
        int P = (S + E) / 2;
        CommonUtil.swap(A, S, P);       // start <> pivot swap!
        int pivot = A[S];
        int i = S, j = E;
        while (i < j) {
            while (pivot < A[j]) {
                j--;
            }
            while (i < j && pivot >= A[i]) {
                i++;
            }
            CommonUtil.swap(A, i, j);   // i <> j swap!
        }
        A[S] = A[i];
        A[i] = pivot;
        return i;
    }


}
