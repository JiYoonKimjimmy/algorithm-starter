package me.jimmyberg.algorithm.doit.chapter07;

/**
 * 문제 038. 나머지 합 구하기
 * - 어떤 수가 소수의 N 제곱 (N >= 2) 일 때 이 수를 '거의 소수'라고 한다.
 * - A 와 B 가 주어질 때 A 보다 크거나 같고, B 보다 작거나 같은 '거의 소수'가 몇 개인이 출력하는 프로그램을 작성하시오.
 * [문제 조건]
 * - A <= 10^14
 * - A <= B <= 10^14
 * [Key point]
 * - 최대 범위에 해당하는 모든 소수를 구해놓는다.
 * - 주어진 범위의 최댓값은 10^14 의 제곱근인 10^7 까지 소수를 탐색해야 한다.
 * - 에라토스테네스의 체를 활용하여 소수를 먼저 구하고, 주어진 소수들이 A ~ B 범위 안에 있는지 판별한다.
 */
public class Question038 {
    public static void main(String[] args) {
        long min = 1;
        long max = 1000;
        long[] A = new long[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }
        // 제곱근까지만 소수 탐색 수행 (에라토스테네스의 체 활용)
        for (int i = 2; i <= Math.sqrt(A.length); i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }
        int count = 0;
        for (int i = 2; i < 10000001; i++) {
            if (A[i] != 0) {
                long temp = A[i];
                while (A[i] <= max / temp) {
                    if (A[i] >= min / temp) {
                        System.out.print("A[i] = " + A[i]);
                        System.out.print(", temp = " + temp);
                        System.out.println(", count = " + count);
                        count++;
                    }
                    temp = temp * A[i];
                }
            }
        }
        System.out.println("count = " + count);
    }
}
