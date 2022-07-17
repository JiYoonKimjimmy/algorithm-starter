package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Scanner;

/**
 * 문제 015. 수 정렬하기 1
 * - 1 <= N <= 1,000 수 배열 정렬하기
 *
 * [Key Point]
 * - O(N^2) 시간 복잡도의 `버블 정렬` 활용!
 * - `버블 정렬`
 * - 인접한 항목을 비교하며 작은 수와 큰 수를 swap 하는 방식
 */
public class Question015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        CommonUtil.printIntArray(arr);
    }
}
