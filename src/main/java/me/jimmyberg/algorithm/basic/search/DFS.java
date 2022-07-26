package me.jimmyberg.algorithm.basic.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * DFS Depth First Search Algorithm
 * 깊이 우선 탐색 알고리즘
 * - 그래프 완전 탐색 기법
 * - 시작 노드로부터, 완전 한 쪽 분기를 정하여 `최대 깊이` 까지 탐색하고,
 * - 다른 쪽 분기를 다시 `최대 깊이` 까지 탐색한다.
 *
 * [인접 리스트 Sample]
 * 8 8
 * 1 7
 * 3 7
 * 4 7
 * 3 4
 * 4 6
 * 3 5
 * 0 4
 * 2 7
 */
public class DFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 노드 갯수
        int E = sc.nextInt();   // 연결 에지 갯수

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.size(); i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        System.out.println("================================");
        for (int i = 0; i < graph.size(); i++) {
            System.out.print(i + " : ");
            for (Integer integer : graph.get(i)) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
        System.out.println("================================");

    }
}
