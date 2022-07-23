package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

/**
 * 문제 022. 수 정렬하기 3
 * - `기수 정렬` 활용하여 수 정렬하기
 *
 * [Key Point]
 * - `기수 정렬` `Radix_sort` 활용하기!
 * - `기수 정렬` 시간 복잡도 : O(kn)
 *  1. 0 ~ 9 까지의 Queue 에 `일의 자릿수` 기준으로 저장한다.
 *  2. `일의 자릿수` 정렬 완료 후에 `pop` 하면서, 다시 `십의 자릿수` 기준으로 Queue 에 저장한다.
 *  3. 동일한 방식으로 `백의 자릿수` 도 저장한다.
 *  4. `백의 자릿수` 까지 저장 완료 후에는 `pop` 하면서 결과를 출력한다.
 * - 우선순위 큐를 활용하면 시간 복잡도를 느리게 하는 요소가 있기 때문에, `구간 합`을 이용하여 `기수 정렬` 구현!
 */
public class Question022 {
    public static void main(String[] args) {
        int[] A = new int[]{215, 15, 344, 372, 294, 100, 8, 145, 24, 198, 831};
        int[] output = new int[A.length];
        int j = 1, count = 0;

        while (count != 5) {
            // `bucket` 은 각 자릿수가 몇개있는지 카운트하는 배열
            int[] bucket = new int[10];
            for (int i = 0; i < A.length; i++) {
                bucket[(A[i] / j) % 10]++;
            }
            System.out.print("bucket - 1 = ");
            CommonUtil.printIntArray(bucket);
            for (int i = 1; i < 10; i++) {
                // `bucket` 의 자릿수 카운트를 구간 합으로 만들기
                bucket[i] += bucket[i - 1];
            }
            System.out.print("bucket - 2 = ");
            CommonUtil.printIntArray(bucket);

            for (int i = A.length - 1; i >= 0; i--) {
                int index = bucket[(A[i] / j % 10)] - 1;
                System.out.print("index = " + index);
                System.out.println(", A[i] = " + A[i]);

                // 현재 자릿수를 기준으로 정렬하기
                output[bucket[(A[i] / j % 10)] - 1] = A[i];
                // 각 자릿수 갯수 내리기
                bucket[(A[i] / j % 10)]--;
            }

            for (int i = 0; i < A.length; i++) {
                // 다음 자릿수로 이동하기 전에, 현재 자릿수 기준 정렬 데이터를 저장하기
                A[i] = output[i];
            }

            // 자릿수 올리기
            j = j * 10;
            // 최대 자릿수까지 count 올리기
            count++;
        }

        CommonUtil.printIntArray(A);
    }
}
