package me.jimmyberg.coupang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 문제. 고정점 찾기
 * - 숫자로 된 배열에서 index 와 value 가 동일한 `고정점` 를 찾는다.
 * - O(logN) 시간 복잡도를 준수하기 위해 선형 탐색이 아닌 방식으로 탐색한다.
 *
 * [Key Point]
 * - `퀵 정렬` 을 활용하여 분할 정복 방식으로 탐색!
 * - 결과 반환 방식 및 임계 종료 방식 고려
 */
public class FindFixedPoint {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(-16, -15, 1, 3, 9, 5);

        System.out.println(sort(list).stream().map(String::valueOf).collect(Collectors.joining(", ")));
    }

    public static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) return list;

        int pivot = list.size() / 2;
        int pivot_num = list.get(pivot);

        List<Integer> lesser = new ArrayList<>(), equal = new ArrayList<>(), greater = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);

            if (num < pivot_num) {
                // lesser group
                lesser.add(num);
            } else if (num > pivot_num) {
                // greater group
                greater.add(num);
            } else {
                 // equal group
                equal.add(num);
            }
        }

        return Stream
                .of(sort(lesser), equal, sort(greater))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
