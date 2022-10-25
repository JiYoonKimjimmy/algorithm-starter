package me.jimmyberg.algorithm.doit.chapter07;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 문제 044. 칵테일 만들기
 * - 칵테일을 만들기 위한 재료를 비율 제조하는데 필요한 각 재료의 양을 구하는 프로그램을 작성하시오.
 * - 필요한 재료의 질량을 모두 더한 값이 최소가 되어야 한다.
 * [Key Point]
 * - 각 재료의 비율을 그래프로 구현한다!
 * - 비율 데이터를 저장할 때마다 비율과 관련된 수들의 최소 공배수를 저장한다!
 * - `DFS` 을 진행하면서 각 재료 노드에 맞는 비율을 출력한다!
 * [입력]
 * 4 0 1 1
 * 4 1 3 1
 * 4 2 5 1
 * 4 3 7 1
 * [출력]
 * 105 35 21 15 105
 */
public class Question044 {

    static ArrayList<Node>[] A;
    static boolean[] visited;
    static int lcm = 1;
    static long[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = 5;

        A = new ArrayList[N];
        visited = new boolean[N];
        result = new long[N];

        for (int i = 0; i < N; i++) {
            A[i] = new ArrayList<>();
        }

        // 재료 비율 저장하면서 최소 공배수 계산
        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            int r1 = sc.nextInt(), r2 = sc.nextInt();

            A[a].add(new Node(a, b, r1, r2));
            A[b].add(new Node(b, a, r2, r1));

            lcm = lcm * r1 * r2 / gcd(r1, r2);
        }
        System.out.println("lcm = " + lcm);

        int start = 0;
        for (Node node : A[start]) {
            result[node.node] = (long) lcm * node.rate1 / node.rate2;
            dfs(node.node);
        }
        System.out.println();
        for (long r: result) {
            System.out.print(r + " ");
        }
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    private static void dfs(int node) {
        // 현재 node 방문 처리
        visited[node] = true;
        // 현재 node 출력
        System.out.print(node + " ");

        for (Node linked : A[node]) {
            if (!visited[linked.linked]) {
                result[linked.linked] = result[node] * linked.rate2 / linked.rate1;
                dfs(linked.linked);
            }
        }
    }
}

class Node {
    int node;
    int linked;
    int rate1;
    int rate2;

    Node(int node, int linked, int rate1, int rate2) {
        this.node = node;
        this.linked = linked;
        this.rate1 = rate1;
        this.rate2 = rate2;
    }

    @Override
    public String toString() {
        return "Node{" +
                "node=" + node +
                ", linked=" + linked +
                ", rate1=" + rate1 +
                ", rate2=" + rate2 +
                '}';
    }
}
