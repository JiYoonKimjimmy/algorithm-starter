package me.jimmyberg.algorithm.doit.chapter05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제 023. 연결 요소의 개수 구하기
 * - 방향 없는 그래프가 주어졌을 때, 연결 요소(Connected Component)의 개수를 구하는 프로그램 구현하기
 *
 * [Key Point]
 * - `연결 요소`? `DFS` 수행하는 횟수 의미
 * - `DFS` 수행? 탐색이 완료되어 스택이 모두 비어진 상태
 *
 * [Sample]
 * 6 5  // 노드 개수, 에지 개수
 * 1 2
 * 2 5
 * 5 1
 * 3 4
 * 4 6
 *
 * 2    // 결과값
 */
public class Question023 {
    static List<List<Integer>> A;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int count = 0;
        A = new ArrayList<>();
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            A.add(new ArrayList<>());
        }

        // 인접 리스트 만들기
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            A.get(s).add(e);
            A.get(e).add(s);
        }

        for (int i = 1; i < A.size(); i++) {
            System.out.print("a[" + i + "] = ");
            for (Integer j : A.get(i)) {
                System.out.print(j + " ");
            }
            System.out.println();

            // 방문하지 않은 node 인 경우, dfs 수행
            if (!visited[i]) {
                dfs(i);
                count++;
            }

            for (boolean v: visited) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        System.out.println("count = " + count);
    }

    static void dfs(int k) {
        if (visited[k]) return;

        visited[k] = true;

        for (Integer i : A.get(k)) {
            // 재귀 호출 방식으로 dfs 수행
            dfs(i);
        }
    }
}
