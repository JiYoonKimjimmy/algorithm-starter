package me.jimmyberg.coupang;

/**
 * 문제. 고정점 찾기
 * - 숫자로 된 배열에서 index 와 value 가 동일한 `고정점` 를 찾는다.
 * - `고정점` 없는 경우엔, `-1` 출력
 * - O(logN) 시간 복잡도를 준수하기 위해 선형 탐색이 아닌 방식으로 탐색한다.
 * [Key Point]
 * - 분할 정복 방식으로 탐색!
 * - 결과 반환 방식 및 임계 종료 방식 고려
 * [Sample]
 * - input : -16, -15, 1, 3, 9, 6
 * - out : 3
 * - input : -16, -15, 1, 2, 4, 6
 * - out : -1
 */
public class MyFindFixedPoint {
    public static void main(String[] args) {
        int[] A = {-16, -15, 1, 2, 5, 6};
//        solution01(A);
        solution02(A);
    }

    private static void solution01(int[] A) {
        int index = 0;
        int result = 0;
        for (int value : A) {
            if (value == index) {
                result = index;
                break;
            }
            index++;
        }
        System.out.println("result = " + result);
    }

    private static void solution02(int[] A) {
        int result = find(A, 0, A.length);
        System.out.println("result = " + result);
    }

    private static int find(int[] A, int start, int end) {
        if (start >= end) return -1;

        int pivot = (start + end) / 2;
        int num = A[pivot];

        if (pivot == num) {
            return num;
        } else if (pivot < num) {
            return find(A, start, pivot);
        } else {
            return find(A, pivot + 1, end);
        }
    }

}
