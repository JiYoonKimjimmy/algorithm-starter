package me.jimmyberg.algorithm.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Quick Sort (퀵 정렬)
 * - 시간 복잡도 : O(N * logN)
 * - Pivot 을 기준으로 왼쪽에서는 Pivot 보다 큰 항목을 찾고,
 * - 오른쪽에서는 Pivot 보다 작은 항목을 찾는 후에, 양 쪽의 항목을 서로 Swap 반복
 * - 왼쪽과 오른쪽 Pivot 기준이 교차되는 순간, Pivot 과 작은 항목를 Swap
 */
public class QuickSort01 {
    public static void main(String[] args) {
        int[] sample = {3, 7, 8, 1, 5, 9, 6, 10, 2, 4};

        String result = sort(Arrays.stream(sample).boxed().collect(Collectors.toList()))
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);

    }

    private static List<Integer> sort(List<Integer> list) {
        if (list.size() <= 1) return list;

        int pivot = list.get(list.size() / 2);
        List<Integer> lesser = new ArrayList<>(), equal = new ArrayList<>(), greater = new ArrayList<>();

        for (int n : list) {
            if (n < pivot) {
                lesser.add(n);
            } else if (n == pivot) {
                equal.add(n);
            } else {
                greater.add(n);
            }
        }

        return Stream.of(sort(lesser), equal, sort(greater))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
