package me.jimmyberg.algorithm.programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question12906 {
    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = 10;
        for (int j : arr) {
            if (prev != j) {
                list.add(j);
            }
            prev = j;
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 1, 3, 3, 0, 1, 1})));
    }
}
