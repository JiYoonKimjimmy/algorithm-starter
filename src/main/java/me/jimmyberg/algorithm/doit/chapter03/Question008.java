package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 008. '좋은 수' 구하기
 * - 주어진 N 개의 수에서 서로 다른 두 수의 합으로 표현되는 수의 갯수 구하기
 * - 1 2 3 4 5 6 7 8 9 10 배열의 총 '좋은 수'의 갯수 : 8개 (3, 4, 5, 6, 7, 8, 9, 10)
 *
 * [Key Point]
 * - '좋은 수'를 구하기 전에 배열을 정렬하는 것도 중요 포인트! (비교를 순차적으로 쉽게 하기 위해서)
 * - 찾고자 하는 '좋은 수' 를 하나씩 올리면서, 모든 배열에서 다시 '좋은 수' 를 찾는다!
 */
public class Question008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        CommonUtil.printIntArray(arr);

        int count = 0;

        for (int k = 0; k < arr.length; k++) {
            int i = 0, j = N - 1, K = arr[k];
            while (i < j) {
                int sum = arr[i] + arr[j];
                if (sum > K) j--;
                if (sum < K) i++;
                if (sum == K) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
        }
        System.out.println("count = " + count);
    }
}
