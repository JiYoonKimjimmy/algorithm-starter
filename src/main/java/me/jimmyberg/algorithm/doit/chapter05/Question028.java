package me.jimmyberg.algorithm.doit.chapter05;

import java.util.*;

/**
 * 문제 028. 트리의 지름 구하기
 * - 트리를 구성하는 노드 중 두 노드 사이의 거리가 가장 긴 지름 구하기
 * - 노드 정보 입력 방법 : a (노드 번호) b (연결 노드) c (a 와 b 노드 사이의 길이)
 * - 입력된 노드 정보 종합하여 탐색하여 최소 위치 부터 최대 위치, 즉 길이가 가장 긴 구간을 탐색
 * <p>
 * [Key Point]
 * - `BFS` 완전 탐색 기법으로, 시작 노드부터 최대 깊이까지의 길이를 구한다!
 * - 최대 depth 까지의 길이가 제일 큰 `길이`를 출력한다!
 * - depth 가 내려갈 때마다 직전 node 의 가중치를 덧셈 계산하고 저장한다!
 */
public class Question028 {
    static int[] distance;
    static boolean[] visited;
    static List<List<Edge>> A;

    public static void main(String[] args) {
        int N = 5;
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        A = new ArrayList<>();

        A.add(List.of());
        A.add(List.of(new Edge(3, 2)));
        A.add(List.of(new Edge(4, 4)));
        A.add(List.of(new Edge(1, 2), new Edge(4, 3)));
        A.add(List.of(new Edge(2, 4), new Edge(3, 3), new Edge(5, 6)));
        A.add(List.of(new Edge(4, 6)));

        List<Integer> results = new ArrayList<>();
        for (int i = 1; i < A.size(); i++) {
            System.out.println("start = " + i);
            bfs(i);
            results.add(Arrays.stream(distance).max().orElse(0));
            distance = new int[N + 1];
            visited = new boolean[N + 1];
        }
        System.out.println("results.size() = " + results.size());
        System.out.println("results = " + results.stream().max(Comparator.comparingInt(a -> a)).orElse(0));
    }

    private static void bfs(int start) {
        visited[start] = true;
        Queue<Edge> queue = new LinkedList<>();
        List<Edge> edges = A.get(start);

        for (Edge edge: edges) {
            queue.add(edge);
            while (!queue.isEmpty()) {
                Edge linked = queue.poll();
                if (!visited[linked.node]) {
                    visited[linked.node] = true;
                    distance[linked.node] = distance[start] + edge.value;
                    bfs(linked.node);
                }
            }

            System.out.print("distance : ");
            for (int d : distance) {
                System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    static class Edge {
        private final int node;
        private final int value;

        Edge(int node, int value) {
            this.node = node;
            this.value = value;
        }
    }
}
