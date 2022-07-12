package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 008. '좋은 수' 구하기
 * - 주어진 N 개의 수에서 서로 다른 두 수의 합으로 표현되는 수의 갯수 구하기
 * - 1 2 3 4 5 6 7 8 9 10 배열의 총 '좋은 수'의 갯수 : 8개 (3, 4, 5, 6, 7, 8, 9, 10)
 * - !! '좋은 수'를 구하기 전에 배열을 정렬하는 것도 Key Point !! (비교를 순차적으로 쉽게 하기 위해서)
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
            int K = arr[k];
            int i = 0;
            int j = N - 1;
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
