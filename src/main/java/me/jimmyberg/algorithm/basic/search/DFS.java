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
 * 6 6  // node 수, edge 수
 * 1 2
 * 1 3
 * 2 5
 * 2 6
 * 3 4
 * 4 6
 *
 * // DFS 실행 결과
 * 1 -> 3 -> 4 -> 6 -> 2 -> 5
 */
public class DFS {
    static List<List<Integer>> graph;
    static Boolean[] visited;
    static List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("============ START =============");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 노드 갯수
        int E = sc.nextInt();   // 연결 에지 갯수

        graph = new ArrayList<>();
        visited = new Boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            visited[i] = false;
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                // i 번째 node 방문하지 않은 경우, 탐색 시작
                dfs(i);
            }
        }

        System.out.println("result : " + String.join(" -> ", result));
    }

    static void dfs(int k) {
        if (visited[k]) {
            // k 번째 node 를 이미 방문한 경우
            return;
        }

        // k 번째 node 방문 처리
        visited[k] = true;
        // 방문 node 결과 저장
        result.add(String.valueOf(k));

        List<Integer> child = graph.get(k);
        for (int i = child.size() - 1; i >= 0; i--) {
            int index = child.get(i);
            if (!visited[index]) {
                dfs(index);
            }
        }

    }
}
