package me.jimmyberg.naver2022;

import java.util.*;

public class Question01 {

    public static int solution(int[] T) {
        int answer = 0;
        int N = T.length;
        int G = N / 2;

        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();
        for (int i : Arrays.stream(T).sorted().toArray()) {
            stack.push(i);
        }
        List<Integer> result = new ArrayList<>();
        int index = 0;
        int prev = 0;
        while (!stack.isEmpty()) {
//            System.out.print(stack.peek() + " ");
            int value = stack.pop();
//            System.out.print("result = " + result.size());
//            System.out.println(", index = " + index);
            if (result.size() < G && value != prev) {
                result.add(value);
                prev = value;
            }
        }

        System.out.println();
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 7, 7, 6, 6}));
        System.out.println(solution(new int[]{80, 80, 1000000, 80, 80, 80, 80, 80, 80, 12345}));
    }

}
