package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문제 012. 오큰수 구하기 (Stack 활용 문제)
 * - 크기 N 인 수열의 각 원소에 대한 오큰수 구하기
 * - 오큰수 : i 번째의 원소의 오른쪽에 있으면서, 그 중 A[i] 보다 크면서 제일 왼쪽에 있는 수 (없는 경우, -1 출력)
 * - 입력 : 3 5 2 7
 * - 출력 : 5 7 7 -1
 */
public class Question012 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
//        int[] arr = {3, 5, 2, 7};
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result[stack.pop()] = arr[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for (int r : result) {
            System.out.print(r + " ");
        }
    }
}
