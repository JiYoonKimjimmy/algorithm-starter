package me.jimmyberg.algorithm.doit.chapter05;

/**
 * 문제 031. 배열에서 K번째 수 찾기
 * - N x N 배열 A을 1차원 배열 B에 넣었을 때의 K 번째 수 찾기
 * - A 배열 항목 공식 = A[i][j] = i * j
 * - A 배열을 오름차순으로 B 배열에 삽입한다.
 * [Key Point]
 * - 이진 탐색 알고리즘을 활용!
 * - `중앙 인덱스` = (`시작 인덱스` + `종료 인덱스`) / 2
 * - `중앙 인덱스` 기준으로 숫자가 작거나 같은 수가 K 보다 작으면, `시작 인덱스` = `중앙 인덱스` + 1 하고, 아니면 `종료 인덱스` = `중앙 인덱스` - 1
 * - `중앙 인덱스` 보다 작거나 같은 수의 개수 = Math.min(`중앙 인덱스` / i, N)
 */
public class Question031 {
    public static void main(String[] args) {
        int N = 3, K = 7;

        int start = 1, end = K;
        int result = 0;
        while (start <= end) {
            int middle = (start + end) / 2;
            int count = 0;

            for (int i = 1; i <= N; i++) {
                // 중앙 인덱스보다 작거나 같은 수 = Math.min(중앙 인덱스 / i, N)
                count += Math.min(middle / i, N);
            }

            if (count < K) {
                start = middle + 1;
            } else {
                end = middle - 1;
                result = middle;
            }

        }

        System.out.println("result = " + result);

    }
}
