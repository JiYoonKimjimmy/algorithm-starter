package me.jimmyberg.algorithm.doit.chapter07;

/**
 * 문제 040. 제곱이 아닌 수 찾기
 * - 어떤 수 X 가 1 보다 큰 제곱수로 나누어떨어지지 않을 때 이 수를 '제곱이 아닌 수' 라고 한다면, 여기서 제곱수는 정수의 제곱이다.
 * - min 과 max 의 값이 주어질 때 min 보다 크고, max 보다 작은 값 중 '제곱이 아닌 수' 가 몇 개 있는지 출력하는 프로그램을 작성하시오.
 * [문제 조건]
 * - 1 <= min <= 1,000,000,000,000
 * - min <= max <= min + 1,000,000
 * [Key Point]
 * - 에라토스테네스의 체 알고리즘을 활용하여 제곱수 판별한다!
 * - min 과 max 사이에 있는 수를 순차적으로 제곱하면서 제곱수인 수를 삭제한다!
 * - 제곱수의 배수 형태로 탐색하면서 시간 복잡도를 최소화한다!
 */
public class Question040 {
    public static void main(String[] args) {
        long min = 1, max = 10;

        // 최댓값과 최솟값의 차이만큼 배열 선언
        boolean[] check = new boolean[(int) (max - min + 1)];

        for (long i = 2; i * i <= max; i++) {
            // 제곱수
            long pow = i * i;
            long start = min / pow;

            // min % pow 나머지가 있는 경우, min 보다 큰 제곱수부터 시작하기 위해 + 1
            if (min % pow > 0) start++;

            for (long j = start; pow * j <= max; j++) {
                // 제곱수 index 를 true 로 변경
                check[(int) ((j * pow) - min)] = true;
            }
        }

        int count = 0;
        for (boolean b : check) {
            if (!b) count++;
        }

        System.out.println("count = " + count);
    }
}
