package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Scanner;

/**
 * 문제 017. 내림차순으로 자릿수 정렬하기
 * - 주어진 수의 각 자릿수를 내림차순으로 정렬
 *
 * [Key Point]
 * - `선택 정렬` 활용하여 내림차순 정렬 처리!
 * - 내림차순 정렬하기 위해서는 최댓값을 찾아서 맨 앞 수와 swap!
 */
public class Question017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] charArr = sc.nextLine().toCharArray();
        int[] intArr = new int[charArr.length];
        for (int i = 0; i < charArr.length; i++) {
            intArr[i] = charArr[i] - '0';
        }
        for (int i = 0; i < intArr.length; i++) {
            int max = i;
            for (int j = i + 1; j < intArr.length; j++) {
                if (intArr[max] < intArr[j]) {
                    max = j;
                }
            }
            if (intArr[i] < intArr[max]) {
                int temp = intArr[i];
                intArr[i] = intArr[max];
                intArr[max] = temp;
            }
        }
        CommonUtil.printIntArray(intArr);
    }
}