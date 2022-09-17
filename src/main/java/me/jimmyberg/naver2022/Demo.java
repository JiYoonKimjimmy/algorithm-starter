package me.jimmyberg.naver2022;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        int[] A = {1, 3, 6, 4, 1, 2, -1};
//        int[] A = {1, 2, 3};
//        int[] A = {-1, -3};
        int[] arr = new int[A.length + 1];
        for (int i : A) {
            if (i > 0) {
                arr[i] = i;
            }
        }
        arr = Arrays.stream(arr).filter(i -> i > 0).sorted().toArray();

        int answer = arr.length == 0 ? 1 : 0;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) != arr[i]) {
                answer = i + 1;
                break;
            }
            answer = arr[i] + 1;
        }
        System.out.println("answer = " + answer);
    }
}
