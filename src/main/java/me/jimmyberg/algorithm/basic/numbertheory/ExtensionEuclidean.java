package me.jimmyberg.algorithm.basic.numbertheory;

import java.util.ArrayList;
import java.util.List;

public class ExtensionEuclidean {
    public static void main(String[] args) {
        int a = 5, b = 9, c = 2;
        int lcm = gcd(5, 9);

        // 5 % 9 = 5 | 0
        // 9 % 5 = 4 | 1
        // 5 % 4 = 1 | 1
        // 4 % 1 = 0 | 4가
        int r = 1;
        List<Integer> v = new ArrayList<>();
        while (r != 0) {
            r = a % b;
            v.add(a / b);
            a = b;
            b = r;
        }

        int x = 1, y = 0;
        for (int i = v.size() - 1; i >= 0; i--) {
            System.out.print("x = " + x);
            System.out.print(", y = " + y);
            System.out.println(", v = " + v.get(i));
            int temp = x;
            x = y;
            y = temp - y * v.get(i);
        }

        int q = c / lcm;

        System.out.print("result : x = " + x * q);
        System.out.println(", y = " + y * q);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            // MOD 연산 결과값이 0 인 경우, a 값 반환
            return a;
        } else {
            // MOD 연산 처리
            return gcd(b, a % b);
        }
    }
}
