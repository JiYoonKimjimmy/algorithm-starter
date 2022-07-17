package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Scanner;

/**
 * 문제 002. 평균 구하기
 * - 입력된 점수 중에 제일 큰 MAX 값을 활용하여 새로운 평균 구하기
 * - 새로운 점수 = 점수 / MAX * 100
 * - 새로운 평균 = (점수1 + 점수2 + ... + 점수N) * 100 / MAX / 3
 *
 * [Key Point]
 * - 문제의 수식을 잘 정리하면 답이 보인다!
 */
public class Question002 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] scores = new int[size];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = sc.nextInt();
        }
        int max = 0, sum = 0;
        for (int score : scores) {
            if (max < score) {
                max = score;
            }
            sum += score;
        }
        System.out.println("result = " + sum * 100.0 / max / size);
    }
}
