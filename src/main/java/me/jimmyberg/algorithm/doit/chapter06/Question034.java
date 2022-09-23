package me.jimmyberg.algorithm.doit.chapter06;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 문제 034. 수를 묶어서 최댓값 만들기
 * - 수열의 합을 구하지만, 구하기 전에 먼저 수열 안에 있는 임의의 두 수를 묶어서 합산을 한다.
 * - 단, 같은 위치에 있는 수(자기 자신)를 묶을 수 없고, 묶인 두 수는 수열의 합을 구할 때 서로 곱한 후 계산된다. 수열의 모든 수는 각 한 번씩만 묶을 수 있다.
 * - 각 묶음 수까지 모두 합산하였을 때, 최댓값을 구한다.
 * [Key Point]
 * 1. 수열을 3가지의 집합으로 나눈다.
 *   - `1보다 큰 양수`
 *   - `1의 개수`
 *   - `0의 개수`
 *   - `음수`
 * 2. `1보다 큰 양수` 집합은 정렬을 한 뒤, 가장 큰 수부터 2개씩 순서대로 곱한 후에 나머지를 더한다.
 * 3. `음수` 집합은 정렬을 한 뒤, 가장 작은 수부터 2개씩 곱하여 더한다. 집합 원소가 홀수일 때, `0의 개수` 집합이 있다면 **0을 곱해서 0으로 만들고,** 없다면 그대로 합산한다.
 * 4. `1의 개수` 집합은 그대로 더한다.
 */
public class Question034 {
    public static void main(String[] args) {
        int N = 9;
        int[] A = {-1, -8, 2, 1, 3, 6, -5, 0, 1};
        System.out.println("A.length = " + A.length);

        PriorityQueue<Integer> positive = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>();
        int one = 0, zero = 0;

        for (int i : A) {
            if (i > 1) {
                positive.add(i);
            } else if (i < 0) {
                negative.add(i);
            } else if (i == 1) {
                one++;
            } else {
                zero++;
            }
        }

        System.out.println("positive = " + positive);
        System.out.println("negative = " + negative);
        System.out.println("one = " + one);
        System.out.println("zero = " + zero);

        int positive_sum = 0, negative_sum = 0;

        while (positive.size() > 1) {
            positive_sum += positive.remove() * positive.remove();
        }
        if (!positive.isEmpty()) {
            positive_sum += positive.remove();
        }

        while (negative.size() > 1) {
            negative_sum += negative.remove() * negative.remove();
        }
        if (zero == 0) {
            negative_sum += negative.remove();
        }

        System.out.println("positive_sum = " + positive_sum);
        System.out.println("negative_sum = " + negative_sum);

        System.out.println("total_sum = " + (positive_sum + negative_sum + one));
    }
}
