package me.jimmyberg.algorithm.doit.chapter05;

/**
 * 문제 030. 블루레이 만들기
 * - i ~ j 까지의 N 개의 레슨 동영상을 순서대로 조합하여 M 개의 블루레이 강의 만들기
 * [Key Point]
 * - 순서 보장하여 탐색해야하므로 이진 탐색 알고리즘 활용!
 * - 이진 탐색의 시작 인덱스는 `최대 길이`, 종료 인덱스는 `모든 레슨 길이의 합`
 * - 탐색의 `중앙 인덱스`은 `시작 인덱스` + `종료 인덱스` / 2
 * - 동영상 배열을 탐색하면서 합산하고, 합산된 크기가 `중앙 인덱스`보다 크다면 count++ & 초기화하고 다음 동영상 크기를 다시 합산!
 * - 합산된 크기가 0 보다 크다면, 마지막 블루레이가 필요하므로 count++ 한번 더!
 * - count < M 이면, `종료 인덱스` 를 `중앙 인덱스` - 1 아니면, `중앙 인덱스` + 1 로 저장!
 * - `시작 인덱스` > `종료 인덱스` 되는 순간 종료!
 * [입력 & 출력]
 * - 입력 : 1 2 3 4 5 6 7 8 9
 * - 출력 : 17
 */
public class Question030 {
    public static void main(String[] args) {
        int N = 9, M = 3;
        int[] A = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int max = 0, total = 0;
        for (int i : A) {
            if (max < i) max = i;
            total += i;
        }
        System.out.println("max = " + max);
        System.out.println("total = " + total);

        int start = max, end = total;
        while (start <= end) {
            int middle = (start + end) / 2;
            System.out.print("start = " + start);
            System.out.print(", end = " + end);
            System.out.println(", middle = " + middle);
            int sum = 0, count = 0;
            for (int i : A) {
                if (sum + i > middle) {
                    count++;
                    sum = 0;
                }
                sum += i;
            }

            if (sum != 0) count++;

            if (count <= M) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }

        System.out.println("start = " + start);
    }
}
