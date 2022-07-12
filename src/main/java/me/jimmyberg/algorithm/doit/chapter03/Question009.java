package me.jimmyberg.algorithm.doit.chapter03;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.Scanner;

/**
 * 문제 009. DNA 비밀번호
 * - 주어진 문자열의 일정한 범위만큼 이동하면서 비밀번호 설정에 유효한 문자열인지 판별하는 경우의 수 구하기
 * - 문자열 : "AAACCTGCCAA", 비밀번호 범위 : 4자리
 * - 비밀번호 설정 조건 : A - 1개이상, C - 1개이상, G - 1개이상, T - 0개 이상
 * - 유효 비밀번호 경우의 수 : 1개 ("GCCA")
 *
 * [Solution]
 * 1. 문자열을 일정한 범위만큼 이동하면서, 각 문자열의 문자 갯수를 카운트하는 배열에 저장
 * 2. 이동할 때, 빠지는 문자는 문자 갯수 카운트 배열에서 빼고, 추가되는 문자는 더한다.
 * 3. 설정 조건에 부합되는 문자열인 경우는 카운트 + 1 한다.
 */
public class Question009 {
    static int[] checkArr = new int[4];  // A C G T 순서 check
    static int[] myArr = new int[4];
    static int check = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = 4;
        int P = 2;
        int result = 0;
        char[] A = {'G', 'A', 'T', 'A'};

        // checkArr 입력하면서, 0 인 경우 check + 1 (0 인 문자는 체크할 필요없으니까)
        for (int i = 0; i < checkArr.length; i++) {
            checkArr[i] = sc.nextInt();
            if (checkArr[i] == 0) check++;
        }

        // 최초 1회 문자열 처리
        for (int i = 0; i < P; i++) {
            char c = A[i];
            add(c);
        }

        if (check == 4) result++;

        // 윈도우 이동하면서 문자열 처리
        for (int i = P; i < S; i++) {
            add(A[i]);          // 추가 항목
            remove(A[i - P]);   // 제거 항목
            if (check == 4) result++;
        }

        System.out.println("result = " + result);
    }

    private static void add(char c) {
        switch (c) {
            case 'A' -> {
                if (++myArr[0] == checkArr[0]) check++;
            }
            case 'C' -> {
                if (++myArr[1] == checkArr[1]) check++;
            }
            case 'G' -> {
                if (++myArr[2] == checkArr[2]) check++;
            }
            case 'T' -> {
                if (++myArr[3] == checkArr[3]) check++;
            }
        }
    }

    private static void remove(char c) {
        switch (c) {
            case 'A' -> {
                if (myArr[0]-- == checkArr[0]) check--;
            }
            case 'C' -> {
                if (myArr[1]-- == checkArr[1]) check--;
            }
            case 'G' -> {
                if (myArr[2]-- == checkArr[2]) check--;
            }
            case 'T' -> {
                if (myArr[3]-- == checkArr[3]) check--;
            }
        }
    }
}
