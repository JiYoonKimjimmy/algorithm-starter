package me.jimmyberg.algorithm.doit.chapter06;

/**
 * 문제 032. 동전 개수의 최솟값 구하기
 * - 소유하고 있는 동전 총 N 종류 중, 동전의 합 K 를 구하기 위한 동전 개수의 최솟값 구하는 프로그램을 작성
 * [Key Point]
 * 1. 동전 N 배열은 오름차순이며 앞 동전의 배수로 이뤄진다. 이는 동전 금액이 큰 동전부터 탐색을 해야한다.
 * 2. K 를 만족하는 최대 금액 동전을 찾고, `K / 동전 금액 = 동전 사용 개수` 를 구하고, 나머지는 K 값으로 변경한다.
 * 3. 다시 *1* 번부터 탐색하면서 같은 동작을 반복한다.
 */
public class Question032 {
    public static void main(String[] args) {
        int N = 10, K = 4790, count = 0;
        int[] coins = {1, 5, 10, 50, 100, 500, 1000, 5000, 10000, 50000};

        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];

            if (coin <= K) {
                // 현재 동전의 금액이 K 와 같거나 작은 경우
                count += K / coin;
                K = K % coin;
            }
        }

        System.out.println("count = " + count);
    }
}
