package me.jimmyberg.naver2022;

import java.util.*;

public class Question01 {

    public static int solution(int[] T) {
        int N = T.length;
        int G = N / 2;

        Stack<Integer> stack = new Stack<>();
        for (int i : Arrays.stream(T).sorted().toArray()) {
            stack.push(i);
        }
        List<Integer> result = new ArrayList<>();
        int prev = 0;
        while (!stack.isEmpty()) {
            System.out.print("stack.peek() = " + stack.peek());
            System.out.println(", result.size() = " + result.size());
            int value = stack.pop();
            if (result.size() < G && value != prev) {
                result.add(value);
                prev = value;
            }
        }

        return result.size();
    }

    public static void main(String[] args) {
        System.out.println("result = " + solution(new int[]{3, 4, 7, 7, 6, 6}));
        System.out.println();
        System.out.println("result = " + solution(new int[]{80, 80, 1000000, 80, 80, 80, 80, 80, 80, 12345, 123, 345}));
    }

}
