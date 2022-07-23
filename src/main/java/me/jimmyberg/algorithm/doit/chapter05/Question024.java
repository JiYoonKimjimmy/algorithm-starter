package me.jimmyberg.algorithm.doit.chapter05;

/**
 * 문제 024. 신기한 소수 찾기 (`DFS` 활용)
 * - N 자리 숫자 중 `신기한 소수` 모두 찾기
 * - `신기한 소수`? 모든 자릿수 숫자가 각각 모두 소수인 경우
 * - 7331 -> 7331 소수, 733 소수, 73 소수, 7 소수
 *
 * [Key Point]
 * - 한 자릿수 부터 자릿수를 늘려가며 각 숫자가 소수인지 아닌지 판별
 * - 한 자릿수에서 소수는 2, 3, 5, 7 밖에 없으므로, 해당 숫자로 DFS 탐색 시작!
 * - DFS 수행하면서, 짝수인 경우는 소수가 아니므로 제외
 * - DFS 수행하면서, 숫자를 조합하여 소수인지 판별하고, 자릿수 + 1 하여 다시 DFS 수행!
 */
public class Question024 {
    static int N = 4;
    public static void main(String[] args) {
        int J = 1;

        // 한 자릿수의 소수는 2, 3, 5, 7 만 있으므로, 해당 숫자로 dfs 첫 수행
        dfs(2, J);
        dfs(3, J);
        dfs(5, J);
        dfs(7, J);
    }

    static void dfs(int k, int J) {
        if (J == N) {
            // 지정한 자릿수에 도달 & 현재 숫자가 소수인 경우, 출력 후 탐색 중단
            if (k % 2 != 0) {
                System.out.println(k);
                return;
            }
        }

        // 0 ~ 9 까지 loop 하면서, 숫자 조합 후 소수인 경우, dfs 재귀 수행
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) continue;
            if (isPrime((k * 10) + i)) {
                dfs((k * 10) + i, J + 1);
            }
        }
    }

    /**
     * 소수 판별 함수
     * @param num 검증 숫자
     * @return 검증 결과
     */
    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                // 소수가 아닌 경우
                return false;
            }
        }
        return true;
    }
}
