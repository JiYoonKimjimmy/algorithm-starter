package me.jimmyberg.algorithm.doit.chapter05;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Arrays;

/**
 * 문제 029. 원하는 정수 찾기
 * - N 개의 정수 A[1], A[2], ... A[N] 에서 `X` 라는 정수 존재하는지 알아내는 프로그램 구현하기
 * - 1 <= N <= 100,000
 * <p>
 * [Key Point]
 * - 최대 범위가 100,000 이므로 단순 반복문보단 `이진 탐색`을 적용하여 O(logN) 시작 복잡도로 해결!
 * - X < A[mid] 인 경우, end = mid - 1
 * - X > A[mid] 인 경우, start = mid + 1
 * - X == A[mid] 인 경우, "1" 출력
 * - 끝 점까지 이동하였지만, 일치한 정수가 없는 경우 "0" 출력
 */
public class Question029 {

    public static void main(String[] args) {
        int[] A = {4, 1, 5, 2, 3};
        int[] X = {1, 3, 7, 9, 5};
        int[] R = new int[A.length];

        A = Arrays.stream(A).sorted().toArray();
        CommonUtil.printIntArray(A);

        for (int i = 0; i < A.length; i++) {
            int start = 0;
            int end = A.length;
            while (start < end) {
                int mid = (start + end) / 2;
                System.out.print("start = " + start);
                System.out.print(", end = " + end);
                System.out.println(", mid = " + mid);
                if (X[i] == A[mid]) {
                    R[i] = 1;
                    break;
                } else if (X[i] > A[mid]) {
                    start = mid + 1;
                } else if (X[i] < A[mid]) {
                    end = mid - 1;
                }
            }
        }
        CommonUtil.printIntArray(R);
    }

}
