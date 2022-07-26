package me.jimmyberg.algorithm.basic.sort;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * Merge Sort (병합 정렬)
 * - 시간 복잡도 : O(NlogN)
 * - 배열의 그룹을 둘로 나눠서 정렬하고,
 * - 나눠진 그룹을 병합하면서 다시 정렬하는 방식
 */
public class MergeSort01 {
    static int[] A, T;
    public static void main(String[] args) {
        int N = 5;
        A = new int[N + 1];
        T = new int[N + 1];
        int index = 1;
        for (int i = N; i > 0; i--) {
            A[index++] = i;
        }
        CommonUtil.printIntArray(A);
        mergeSort(1, N);
        CommonUtil.printIntArray(A);
    }

    public static void mergeSort(int S, int E) {
        // 시작점이 종료점을 넘은 경우
        if (E - S < 1) return;
        
        int M = (S + E) / 2;

        mergeSort(S, M);
        mergeSort(M + 1, E);

        for (int i = S; i <= E; i++) {
            T[i] = A[i];
        }
        System.out.print("T = ");
        CommonUtil.printIntArray(T);
        int index1 = S;
        int index2 = M + 1;
        int K = S;

        while (index1 <= M && index2 <= E) {
            if (T[index1] < T[index2]) {
                A[K++] = T[index1++];
            } else {
                A[K++] = T[index2++];
            }
        }
        System.out.print("A - 1 = ");
        CommonUtil.printIntArray(A);

        while (index1 <= M) {
            A[K++] = T[index1++];
        }
        while (index2 <= E) {
            A[K++] = T[index2++];
        }
        System.out.print("A - 2 = ");
        CommonUtil.printIntArray(A);
        System.out.println("====================");
    }
}
