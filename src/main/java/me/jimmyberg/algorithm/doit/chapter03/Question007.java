package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 007. 주몽의 명령
 * - 재료의 배열 요소간의 합 중에 주어진 숫자와 일치한 경우의 수 구하기
 */
public class Question007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        CommonUtil.printIntArray(arr);
        Arrays.sort(arr);
        CommonUtil.printIntArray(arr);

        int start = 0, end = N - 1, count = 0;
        while (start < end) {
            if (arr[start] + arr[end] < M) {
                start++;
            }
            if (arr[start] + arr[end] > M) {
                end--;
            }
            if (arr[start] + arr[end] == M) {
                start++;
                end--;
                count++;
            }
        }
        System.out.println("count = " + count);
    }
}
