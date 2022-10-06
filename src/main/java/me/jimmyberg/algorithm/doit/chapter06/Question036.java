package me.jimmyberg.algorithm.doit.chapter06;

import java.util.Arrays;

/**
 * 문제 036. 최솟값을 만드는 괄호 배치 찾기
 * - 양수와 `+`, `-`, 괄호를 이용한 수식에서 괄호를 모두 지우고, 다시 괄호를 넣어서, 수식의 최솟값을 구하기
 * [Key Point]
 * - 최솟값을 구하기 위해서는 `큰 수`를 빼야한다.
 * - `큰 수`를 만들기 위해서는 괄호는 다시 넣을 때, `+` 연산자 중심으로 묶고, 합산된 수를 뺀다.
 * <p>
 * 1. 주어진 문자열의 괄호를 모두 제거한다.
 * 2. `-` 연산자 기준으로 문자열을 split 한다.
 * 3. 나눠진 문자열 배열을 합산한다.
 * 4. 합산된 수를 모두 뺀다.
 */
public class Question036 {
    public static void main(String[] args) {
        // 10
        String str = "(100-40)+(10-10)+30";

        str = str.replaceAll("[()]", "");

        int result = Arrays
                .stream(str.split("-"))
                .map(a -> Arrays.stream(a.split("\\+")).map(Integer::parseInt).reduce(0, Integer::sum))
                .reduce((a, b) -> a - b)
                .orElse(0);

        System.out.println("result = " + result);
    }
}
