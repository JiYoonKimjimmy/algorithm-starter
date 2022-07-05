package me.jimmyberg.algorithm.common;

public class CommonUtil {

    public static void swap(int[] data, int n1, int n2) {
        int temp = data[n1];
        data[n1] = data[n2];
        data[n2] = temp;
    }

    public static void printIntArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

}
