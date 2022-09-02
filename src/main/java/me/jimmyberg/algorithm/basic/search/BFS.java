package me.jimmyberg.algorithm.basic.search;

import java.util.*;

/**
 * BFS Breadth First Search Algorithm
 * 너비 우선 탐색 알고리즘
 * - 그래프 완전 탐색 기법
 * - 시작 노드로부터, 가장 가까운 노드를 먼저 방문하고 탐색하는 기법
 *
 * [인접 리스트 Sample]
 * 6 6 1  // node 수, edge 수, 시작 node
 * 1 2
 * 1 3
 * 2 5
 * 2 6
 * 3 4
 * 4 6
 *
 * // DFS 실행 결과
 * 1 -> 2 -> 3 -> 5 -> 6 -> 4
 */
public class BFS {

    static List<String> result = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) {
        System.out.println("============ START =============");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[N + 1];

        for (int i = 1; i < graph.size(); i++) {
            System.out.print(i + " : ");
            for (int n : graph.get(i)) {
                System.out.print(n + " ");
            }
            System.out.println();
        }

        bfs(S);

        System.out.println(String.join(" -> ", result));
    }

    private static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int n = queue.poll();
            result.add(String.valueOf(n));

            for (int child : graph.get(n)) {
                if (!visited[child]) {
                    visited[child] = true;
                    queue.add(child);
                }
            }

        }
    }
}
