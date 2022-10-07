package me.jimmyberg.algorithm.basic;

import java.util.ArrayList;
import java.util.List;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int N = 30;
        int[] A = new int[N];

        for (int i = 1; i <= 30; i++) {
            A[i - 1] = i;
        }

        for (int i = 0; i < A.length; i++) {
            int t = A[i];
            if (t != 1) {
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] % t == 0) {
                        A[j] = 1;
                    }
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int j : A) {
            if (j != 1) {
                list.add(j);
            }
        }
        System.out.println("list = " + list);
    }
}
