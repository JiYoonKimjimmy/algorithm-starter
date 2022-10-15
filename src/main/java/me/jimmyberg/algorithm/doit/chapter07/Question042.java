package me.jimmyberg.algorithm.doit.chapter07;

/**
 * 문제 042. 최소 공배수 구하기
 * - 두 자연수 A 와 B 가 있을 때 A 의 배수이면서 B 의 배수인 자연수를 A 와 B 의 공배수라고 한다.
 * - 이런 공배수 중 가장 작은 수가 최소 공배수일 때, A 와 B 의 최소 공배수를 구하는 프로그램을 작성하시오.
 * [Key Point]
 * - `최소 공배수 = A * B / 최대 공약수` 계산하여 구할 수 있다.
 */
public class Question042 {
    public static void main(String[] args) {
        int a = 13, b = 17;
        int result = (a * b) / gcd(a, b);
        System.out.println("result = " + result);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
