package me.jimmyberg.algorithm.doit.chapter06;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Arrays;

/**
 * 문제 035. 회의실 배정하기
 * - 1 개의 회의실에서 N 개의 회의를 진행하기 위한 회의실 사용표 만드는 프로그램
 * - 각 회의의 시작 시간과 종료 시간이 주어진 경우, 겹치치 않게 회의를 정렬하여 최대 몇 번까지 회의를 할 수 있는지 확인한다.
 * - 앞 회의의 종료 시간과 시작 시간 같은 경우는 바로 시작하는 것으로 배정이 가능하다.
 * [Key Point]
 * - 현재 회의의 종료 시간이 빠를 수록 다음 회의와 겹치지 않게 시작하는 것이 유리하다는 점을 활용한 `그리디 알고리즘` 적용!
 * - 종료 시간이 빠른 순으로 회의 시간 배열을 정렬! (종료 시간이 같은 경우, 시작 시간이 빠른 순으로 정렬!)
 * - 앞 회의의 종료 시간보다 현재 회의의 시작 시간이 빠른 경우, 겹치는 회의이기 때문에 `count + 1` 한다!
 */
public class Question035 {
    public static void main(String[] args) {
        int[][] A = new int[][]{
            {1, 4},
            {4, 5},
            {3, 5},
            {0, 6},
            {5, 7},
            {3, 8},
            {5, 9},
            {6, 10},
            {8, 11},
            {8, 12},
            {2, 13},
            {12, 14}
        };

        Arrays.sort(A, (o1, o2) -> {
            int end1 = o1[1];
            int end2 = o2[1];

            if (end1 == end2) {
                return o1[0] - o2[0];
            } else {
                return end1 - end2;
            }
        });

        for (int[] a : A) {
            CommonUtil.printIntArray(a);
        }

        int end = -1, count = 0;
        for (int[] a: A) {
            if (a[0] >= end) {
                count++;
                end = a[1];
            }
        }
        System.out.println("count = " + count);
    }
}
