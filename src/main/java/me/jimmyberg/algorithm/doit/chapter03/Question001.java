package me.jimmyberg.algorithm.doit.chapter03;

import java.util.Scanner;

/**
 * 문제 001. 숫자의 합 구하기
 * - N 개의 숫자가 공백 없이 입력된 경우, 합산 구하기
 */
public class Question001 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();
        System.out.println("data = " + data);
        int result = 0;
        for (char c : data.toCharArray()) {
            result += c - '0';
        }
        System.out.println("result = " + result);
    }
}
