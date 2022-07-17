package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Scanner;

/**
 * 문제 005. 나머지 합 구하기
 * - N 개의 수 A1, A2, ... An 에 대한 숫자 부분 합이 M 으로 나누어떨어지는 구간의 개수를 구하기
 * - 5 3
 * - 1 2 3 1 2
 * - 총 3 으로 나누어떨어지는 구간의 개수 : 7 개!
 *  - 각 구간별 합산에서 3 으로 딱 나누어떨어지는 경우의 수 : 3 개
 *  - 나머지가 같은 인덱스 중 2개 뽑는 경우의 수 : 3 개 + 1 개 = 4개
 *
 *  [Key Point]
 *  - 배열의 각 구간별 합산을 하면서, 나머지 결과에 대한 별도 배열에 저장!
 *  - 나머지 결과 배열의 경우의 수를 구하고 합산!
 *  - '경우의 수' 수식 : N * (N - 1) / 2
 */
public class Question005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        int size = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("size = " + size);
        System.out.println("m = " + m);

        int[] numbers = new int[size + 1];
        int[] reminders = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            numbers[i] = numbers[i - 1] + sc.nextInt();
            int reminder = numbers[i] % m;
            if (reminder == 0) answer++;
            reminders[reminder]++;
        }
        CommonUtil.printIntArray(numbers);
        CommonUtil.printIntArray(reminders);

        for (int i = 0; i < size; i++) {
            if (reminders[i] > 1) {
                answer += reminders[i] * (reminders[i] - 1) / 2;
            }
        }

        System.out.println("answer = " + answer);
    }
}
