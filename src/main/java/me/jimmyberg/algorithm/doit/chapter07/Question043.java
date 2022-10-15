package me.jimmyberg.algorithm.doit.chapter07;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * 문제 043. 최대 공약수 구하기
 * - 모든 자리가 1로만 이뤄진 두 자연수 A, B의 최대 공약수 구하는 프로그램을 작성하시오.
 * - 입력은 두 자연수의 길이가 입력된다.
 * [문제 예시]
 * - 입력 : 3 6   // 3: 111 , 6: 111111
 * - 출력 : 111
 * [Key Point]
 * - 입력은 두 자연수의 길이를 나타내지만, 두 수의 최대 공약수는 A 와 B 의 최대 공약수의 길이를 나타낸다!
 * - `3` 과 `6` 의 최대 공약수인 `3` 은 `111` 와 `111111` 의 최대 공약수 `111` 로 나타낼 수 있다!
 */
public class Question043 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = 3, b = 6;
        int result = gcd(a, b);
        while (result > 0) {
            bw.write("1");
            result--;
        }
        bw.flush();
        bw.close();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
