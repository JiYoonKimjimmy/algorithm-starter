package me.jimmyberg.algorithm.doit.chapter07;

/**
 * 문제 039. 소수 & 팰린드롬 수 중에서 최솟값 찾기
 * - 어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 '팰린드롬' 이라 부른다.
 * - 어떤 수 N (1 <= N <= 1,000,000) 에 대해 N 보다 크거나 같고, 소수이면서 펠린드롬인 수 중 가장 작은 수를 구하는 프로그램을 작성하시오.
 * [Key Point]
 * - 에라토스테네스의 체를 활용해 먼저 소수를 구해놓는다.
 * - 소수 중에서 팰림드롬 수를 찾을 때는, '두 포인터' 를 활용하여 판별한다.
 */
public class Question039 {
    public static void main(String[] args) {
        int N = 31;
        int[] A = new int[10000001];
        for (int i = 2; i < A.length; i++) {
            A[i] = i;
        }

        for (int i = 2; i < A.length; i++) {
            if (A[i] == 0) {
                continue;
            }
            for (int j = i + i; j < A.length; j = j + i) {
                A[j] = 0;
            }
        }

//        String result = "";
//        while (result.length() == 0) {
//            if (A[N] != 0) {
//                String n = String.valueOf(A[N]);
//                int start = 0, end = n.length() - 1;
//                boolean flag = true;
//                while (start < end && flag) {
//                    flag = n.charAt(start) == n.charAt(end);
//                    start++;
//                    end--;
//                }
//                if (start == end) {
//                    result = n;
//                }
//            }
//            N++;
//        }
//        System.out.println("result = " + result);

        while (true) {
            if (A[N] != 0 && isPalindrome(A[N])) {
                System.out.println("result = " + A[N]);
                break;
            }
            N++;
        }
    }

    private static boolean isPalindrome(int target) {
        char[] T = String.valueOf(target).toCharArray();
        int start = 0, end = T.length - 1;

        while (start < end) {
            if (T[start] != T[end]) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
