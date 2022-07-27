package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Scanner;

/**
 * 문제 004. 구간 합 구하기 2
 * - N x N 개의 숫자 표에서 (x1, y1) ~ (x2, y2) 까지의 구간 합 구하기
 * - N x N 숫자 입력 표 A
 * - N x N 각 구간별 합산 표 D
 * - 구간별 합산 = 해당 구간을 둘러싼 구간 합을 빼면 시작점부터 끝점까지의 구간 합!!
 *
 * [Key Point]
 * - 각 구간의 합에 대한 수식 정리하고 미리 계산하여 저장한다!
 *      - D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]
 * - 시작점 ~ 끝점 구간 합 수식 정리하여 출력한다!
 *      - D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1]
 *      - D[x1 - 1][y1 - 1] 를 더하는 이유? 중복되기 때문에!
 */
public class Question004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int quiz = sc.nextInt();
        System.out.println("size = " + size);
        System.out.println("quiz = " + quiz);

        int[][] D = new int[size + 1][size + 1];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                int n = sc.nextInt();
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + n;
            }
        }

        for (int q = 0; q < quiz; q++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println("result = " + result);
        }

    }
}
