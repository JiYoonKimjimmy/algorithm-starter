package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Scanner;

/**
 * 문제 006. 연속된 자연수의 합 구하기
 * - 자연수 N 의 연속된 자연수의 합의 경우의 수를 구하기
 * - N : 15 인 경우
 *  - 1 + 2 + 3 + 4 + 5
 *  - 4 + 5 + 6
 *  - 7 + 8
 *  - 15
 * - 총 : 4
 *
 * [Key Point]
 * - 두 포인터 활용!
 * - start 부터 end 까지의 구간 합을 구하면서, 조건에 맞는 합인 경우 count!
 */
public class Question006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int start = 1, end = 1, sum = 1, count = 0;

        while (end < N) {
            if (sum < N) {
                end++;
                sum += end;
            }
            if (sum > N) {
                sum -= start;
                start++;
            }
            if (sum == N) {
                end++;
                sum += end;
                count++;
            }
        }

        System.out.println("count = " + count);
    }
}
