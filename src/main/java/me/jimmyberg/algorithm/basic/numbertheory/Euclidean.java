package me.jimmyberg.algorithm.basic.numbertheory;

public class Euclidean {
    public static void main(String[] args) {
        int a = 270, b = 192;
        System.out.println("solution1() = " + solution1(a, b));
        System.out.println("solution2() = " + solution2(a, b));
    }

    private static int solution1(int a, int b) {
        int min = Math.min(a, b);
        int result = a % b;

        while (result > 0) {
            int temp = result;
            result = min % result;
            min = temp;
        }

        return min;
    }

    private static int solution2(int a, int b) {
        // 재귀 방식으로 유클리드 호제법 구현
        return gcd(a, b);
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
