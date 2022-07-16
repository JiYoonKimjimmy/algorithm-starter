package me.jimmyberg.algorithm.doit.chapter03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 011. 스택으로 오름차순 수열 만들기
 * - 임의의 수열을 스택에 넣었다가 출력하는 방식으로 오름차순 수열을 출력할 수 있는지 확인 및 연산 순서 출력
 *
 * - 입력 수열 : 4 3 6 8 7 5 2 1
 * - 출력 : + + + + - - + + - + + - - - - -
 */
public class Question011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
//        int[] arr = {4, 3, 6, 8, 7, 5, 2, 1};
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int num = 1;

        for (int k : arr) {
            if (num <= k) {
                while (num <= k) {
                    stack.push(num++);
                    result.add("+");
                }
                stack.pop();
                result.add("-");
            } else {
                int p = stack.pop();
                if (p > k) {
                    System.out.println("NO");
                    result.clear();
                    break;
                } else {
                    result.add("-");
                }
            }
        }

        for (String r : result) {
            System.out.print(r + " ");
        }
    }
}
