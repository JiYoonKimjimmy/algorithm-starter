package me.jimmyberg.algorithm.doit.chapter04;

import me.jimmyberg.algorithm.common.CommonUtil;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제 016. 버블 소트 프로그램 1
 * - 입력된 수의 배열를 버블 정렬하지만, swap 되지 않는 index 구하기
 *
 * - 각 배열의 데이터에 대한 "정렬 전 index" 와 "정렬 후 index" 를 구하여, 각각 위치에 맞는 index 끼리 뺀다.
 * - 뺄셈을 한 index 중 제일 큰 수와 (swap 일어나지 않는 반복문에 대한) 1 를 더하면 결과값을 도출할 수 있다.
 *
 * [Key Point]
 * - 버블 정렬의 속성을 이해한다!
 * - 버블 정렬은 왼쪽에서 오른쪽으로 이동하면서 swap 를 수행한다!
 * - 이는 특정 데이터가 loop 를 돌면서 왼쪽에서 오른쪽으로 1 씩 이동한다는 것을 의미한다!
 */
public class Question016 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Question016Data[] arr = new Question016Data[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new Question016Data(i, sc.nextInt());
        }

        Arrays.sort(arr);

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            // i : 정렬 전 index
            if (max < arr[i].index - i) {
                max = arr[i].index - i;
            }
        }

        System.out.println(max + 1);
    }

    static class Question016Data implements Comparable<Question016Data> {
        private final int index;
        private final int value;

        Question016Data(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(@NotNull Question016Data o) {
            return this.value - o.value;
        }
    }
}
