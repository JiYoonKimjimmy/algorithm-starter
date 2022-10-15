package me.jimmyberg.algorithm.basic.numbertheory;

public class PhiOfEuler {
    public static void main(String[] args) {
        System.out.println("Math.sqrt(2) = " + Math.sqrt(2));
        System.out.println("Math.sqrt(4) = " + Math.sqrt(4));
        System.out.println("Math.sqrt(8) = " + Math.sqrt(8));
        solution();
    }

    private static void solution() {
        long n = 99;
        long result = n;

        // 제곱근까지만 탐색 진행
        for (long p = 2; p <= Math.sqrt(n); p++) {
            // p 가 소수인지 확인
            if (n % p == 0) {
                // 소수인 경우 결과값 변경
                result = result - result / p;
                while (n % p == 0) {
                    // `2^7 * 11` 이라면 `2^7` 을 없애고 `11` 만 남김
                    // `n` 을 *소인수*로 만든다.
                    n /= p;
                }
            }
        }

        if (n > 1) {
            // 반복문에서 제곱근까지만 탐색하기 때문에, 1개의 소인수 구성이 남아있는 경우
            result = result - result / n;
        }

        System.out.println("result = " + result);
    }
}
