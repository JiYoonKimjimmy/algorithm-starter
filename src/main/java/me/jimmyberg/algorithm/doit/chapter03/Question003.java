package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 문제 003. 구간 합 구하기
 * - N 개의 수의 i 번째 수에서 j 번째 수까지의 합 구하기
 * - S[i] = S[i - 1] + A[i] 공식을 이용하여 풀어보기
 */
public class Question003 {
    public static void main(String[] args) {
        try {
//            solution1();
//            solution2();
            solution3();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void solution1() {
        Scanner sc = new Scanner(System.in);

        String[] settings = sc.nextLine().split(" ");
        int size = Integer.parseInt(settings[0]);
        int row = Integer.parseInt(settings[1]);
        System.out.println("size = " + size);
        System.out.println("row = " + row);
        int[] numbers = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            int number = sc.nextInt();
            if (i == 1) {
                numbers[i] = number;
            } else {
                numbers[i] += numbers[i - 1] + number;
            }
        }
        System.out.println("numbers = " + numbers.length);
        CommonUtil.printIntArray(numbers);
        System.out.println();
        for (int r = 0; r < row; r++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            System.out.println(i + " ~ " + j + " = " + (numbers[j] - numbers[i - 1]));
        }
    }

    public static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int suNo = Integer.parseInt(st.nextToken());
        int quizNo = Integer.parseInt(st.nextToken());
        long[] S = new long[suNo + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            System.out.println(S[j] - S[i - 1]);
        }
    }

    public static void solution3() {
        Scanner sc = new Scanner(System.in);
        int suNo = sc.nextInt();
        int quizNo = sc.nextInt();
        System.out.println("suNo = " + suNo);
        System.out.println("quizNo = " + quizNo);

        int[] numbers = new int[suNo + 1];
        for (int i = 1; i <= suNo; i++) {
            int number = sc.nextInt();
            numbers[i] = number + numbers[i - 1];
        }
        CommonUtil.printIntArray(numbers);

        for (int q = 0; q < quizNo; q++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int sum = numbers[j] - numbers[i - 1];
            System.out.println("sum = " + sum);
        }
    }
}
