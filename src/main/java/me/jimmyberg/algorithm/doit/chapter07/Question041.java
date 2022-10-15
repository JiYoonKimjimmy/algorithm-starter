package me.jimmyberg.algorithm.doit.chapter07;

/**
 * 문제 041. 오일러 피 함수 구현하기
 * - 자연수 n 에 대해서 `GCD(n, k) = 1(1 <= k <= n)` 조건을 만족하는 자연수의 개수를 구하는 프로그램을 작성하시오.
 * [Key Point]
 * - `GCD(n, k) = 1` 조건을 만족하는 자연수의 개수는 `오일러 피 함수` 정의이므로 `오일러 피 함수`를 활용!
 * - 오일러 피 핵심 이론 부분을 참고해서 `2 ~ N` 의 제곱근까지 탐색하면서 소인수일 때, `result = result - (result / 소인수)` 연산한다.
 * - `n` 은 다시 소인수로 나누기 연산한다.
 * - 모든 수를 탐색하고 난 후에 현재 `n` 이 `1` 보다 크면, `n` 이 마지막 소인수라는 뜻으로, 한번 더 `result = result - (result / n)` 연산한다.
 */
public class Question041 {

    public static void main(String[] args) {
        long n = 45;
        long result = n;

        for (long k = 2; k <= Math.sqrt(n); k++) {
            if (n % k == 0) {
                // k 가 소인수인 경우
                result = result - (result / k);

                while (n % k == 0) {
                    // n 을 소인수로 만든다.
                    n = n / k;
                }
            }
        }

        if (n > 1) {
            // n 이 1 보다 크다면, 소인수 구성이 남아있는 경우이므로 한번 더 연산 작업
            result = result - (result / n);
        }

        System.out.println("result = " + result);

    }

}
