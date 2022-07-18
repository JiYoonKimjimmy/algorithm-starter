package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * 문제 018. ATM 인출 시간 계산하기
 * - 1 ~ N 번까지의 사람이 P 분씩 현금 인출 시간이 걸린다고 할 때, 모든 사람이 현금 인출 만료되는 최솟값 시간 구하기
 * -
 *
 * [Key Point]
 * - `그리디 방식` 활용하기!
 *  - `그리디 방식` 은, 가장 소요 시간이 적은 순서대로 정렬하여 처리하는 방식
 *  - 정렬 후, 구간 합을 통해서 전체 소용 시간 합산!
 * - `삽입 정렬` 활용하기!
 *  1. 현재 index 데이터 값을 선택
 *  2. 현재 선택한 데이터가 정렬된 데이터 범위에 삽입될 위치 탐색
 *  3. 삽입 위치부터 index 에 있는 위치까지 shift 연산 수행
 *  4. 삽입 위치에 현재 선택한 데이터를 사입, index++ 연산 수행
 *  5. 전체 데이터의 크기만큼 index 이동하여, 선택할 데이터 없을 때까지 반복
 */
public class Question018 {
    public static void main(String[] args) {
        int N = 5;
        int[] P = {3, 1, 4, 3, 2};
        int[] S = new int[N];
        for (int i = 0; i < N - 1; i++) {
            int j = i;
            while (j >= 0 && P[j] > P[j + 1]) {
                int temp = P[j];
                P[j] = P[j + 1];
                P[j + 1] = temp;
                j--;
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                S[i] = P[i];
            } else {
                S[i] = P[i] + S[i - 1];
            }
            result += S[i];
        }
        System.out.println("result = " + result);
    }
}
