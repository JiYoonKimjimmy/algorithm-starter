package me.jimmyberg.algorithm.doit.chapter07;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 문제 037. 소수 구하기
 * - M 이상 N 이하의 소수를 구하는 프로그램을 작성하시오.
 * - 조건 : 1 <= M <= N <= 1,000,000
 * [Key Point]
 * - M, N 의 범위가 크므로 `에라토테네스의 체` 알고리즘을 활용!
 */
public class Question037 {
    public static void main(String[] args) {
        int M = 3, N = 16;
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = i + 1;
        }
        CommonUtil.printIntArray(A);
        for (int i = 1; i < A.length; i++) {
            int t = A[i];
            if (t != 0) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] % t == 0) {
                        A[j] = 0;
                    }
                }
            }
        }
        CommonUtil.printIntArray(A);
        List<Integer> list = new ArrayList<>();
        for (int i = M - 1; i < A.length; i++) {
            if (A[i] != 0) {
                list.add(A[i]);
            }
        }
        System.out.println("list = " + list);
    }
}
