package me.jimmyberg.algorithm.doit.chapter05;

import java.util.*;

/**
 * 문제 026. DFS 와 BFS 프로그램
 * - 그래프를 DFS 로 탐색한 결과와 BFS 로 탐색한 결과를 출력하는 프로그램을 장성하기
 * - 단, 방문할 수 있는 노드가 여러 개일 경우에는 노드 변호가 작은 것을 먼저 방문
 * - 더 이상 방문할 노드가 없는 경우 프로그램 종료
 *
 * [Key Point]
 * - `DFS` 와 `BFS` 를 구현하고 동시 수행한다!
 */
public class Question026 {
    static List<String> dfs_result = new ArrayList<>();
    static List<String> bfs_result = new ArrayList<>();
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] dfs_visited;
    static boolean[] bfs_visited;

    public static void main(String[] args) {
        System.out.println("============ START =============");
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        dfs_visited = new boolean[N + 1];
        bfs_visited = new boolean[N + 1];

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (List<Integer> child : graph) {
            child.sort(Comparator.comparingInt(o -> o));
        }

        dfs(start);
        bfs(start);

        System.out.println("dfs result : " + String.join(" ", dfs_result));
        System.out.println("bfs result : " + String.join(" ", bfs_result));
    }

    static void dfs(int k) {
        if (dfs_visited[k]) return;

        dfs_visited[k] = true;
        dfs_result.add(String.valueOf(k));

        for (int i : graph.get(k)) {
            if (!dfs_visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int k) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);
        bfs_visited[k] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            bfs_result.add(String.valueOf(node));

            for (int i : graph.get(node)) {
                if (!bfs_visited[i]) {
                    bfs_visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
