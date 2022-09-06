package me.jimmyberg.algorithm.doit.chapter05;

import kotlin.Pair;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * 문제 027. 미로 탐색하기
 * - 미로의 각 칸에 들어 있는 숫자 중 `1`은 이동할 수 있는 칸, `0`은 이동할 수 없는 칸을 나타낸다.
 * - 한칸에서 다른 칸으로 이동할 때는 인접한 칸으로 이동할 수 있다.
 * - 위 조건에 맞게 시작 위치에서 도착 위치까지의 지나가야하는 칸의 갯수를 구한다.
 *
 * [Key Point]
 * - 완전 탐색 기법을 활용하지만, 몇 번째 깊이에서 원하는 값을 찾을 수 있는 `BFS` 알고리즘을을 활용!
 * - `BFS` 알고리즘은 해당 깊이에서 탐색을 마친 후, 다음 깊이로 넘어가기 때문에 이 문제에 더 어울리는 기법이다!
 */
public class Question027 {
//    static int[][] matrix = {
//            {0, 0, 0, 0, 0, 0, 0, 0},
//            {0, 1, 1, 0, 1, 1, 0, 0},
//            {0, 1, 1, 0, 1, 1, 0, 0},
//            {0, 1, 1, 1, 1, 1, 1, 0},
//            {0, 1, 1, 1, 1, 0, 1, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0}
//    };
    static int[][] matrix = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 1, 1, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 1, 1, 0, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };
    static boolean[][] visited;

    public static void main(String[] args) {
        int N = 4, M = 6;
        int x = 4, y = 6;

        visited = new boolean[N + 2][M + 2];

        for (int i = 1; i < matrix.length - 1; i++) {
            for (int j = 1; j < matrix[i].length - 1; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        bfs(1, 1);

        System.out.println("result = " + (matrix[x][y] - 1));
    }

    private static void bfs(int i, int j) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(i, j));

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            int x = node.getFirst();
            int y = node.getSecond();

            int up    = matrix[x - 1][y];
            int down  = matrix[x + 1][y];
            int left  = matrix[x][y - 1];
            int right = matrix[x][y + 1];

            if (up    == 1 && !visited[x - 1][y]) queue.add(new Pair<>(x - 1, y));
            if (down  == 1 && !visited[x + 1][y]) queue.add(new Pair<>(x + 1, y));
            if (left  == 1 && !visited[x][y - 1]) queue.add(new Pair<>(x, y - 1));
            if (right == 1 && !visited[x][y + 1]) queue.add(new Pair<>(x, y + 1));

            if (matrix[x][y] == 1 && !visited[x][y]) {
                visited[x][y] = true;
                matrix[x][y] = max(up, down, left, right) + 1;
            }

            if (x == 4 && y == 6) {
                break;
            }
        }
    }

    private static int max(int up, int down, int left, int right) {
        return Stream.of(up, down, left, right).max(Comparator.comparingInt(a -> a)).get();
    }
}
