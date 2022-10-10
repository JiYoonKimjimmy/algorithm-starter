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
 * [시간 복잡도 줄이기 (solution2)]
 * - !! N 의 제곱근까지만 탐색하기 !!
 *    - `N = a * b` 라고 가정했을 때, a 와 b 모두 N 의 제곱근보다 클 수 없다.
 *    - N 의 제곱근까지만 확인해도 전체 범위의 소수 판별 가능하다.
 *    - 예를 들어, N = 16 이라면 16 = 4 * 4 이므로, 16 보다 작은 숫자는 항상 4 보다 작은 약수를 갖게 된다.
 *    - 따라서 4 까지만 탐색해도 소수 판별이 가능하다.
 * - !! `i 의 배수` 숫자부터 i 를 더해 `i 의 배수`를 찾아서 제거하기 !!
 */
public class Question037 {

    static void solution1() {
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
                    System.out.print("i = " + i);
                    System.out.print(", j = " + j);
                    System.out.println(", A[j] = " + A[j]);
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

    static void solution2() {
        int M = 3, N = 16;
        int[] A = new int[N + 1];
        for (int i = M - 1; i <= N; i++) {
            A[i] = i;
        }
        CommonUtil.printIntArray(A);

        for (int i = M - 1; i <= Math.sqrt(N); i++) {
            // N의 제곱근까지만 탐색
            if (A[i] == 0) {
                continue;
            }

            for (int j = i + i; j <= N; j = j + i) {
                // i 의 배수 숫자부터 i 를 더해 i 의 배수를 찾아서 제거
                System.out.print("i = " + i);
                System.out.print(", j = " + j);
                System.out.println(", A[j] = " + A[j]);
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) System.out.print(A[i] + " ");
        }
    }

    public static void main(String[] args) {
        solution1();
        solution2();
    }
}
