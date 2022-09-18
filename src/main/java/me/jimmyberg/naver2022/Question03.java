package me.jimmyberg.naver2022;

import kotlin.Pair;
import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Question03 {

    public static int solution(String L1, String L2) {
        char[] l1 = L1.toCharArray();
        char[] l2 = L2.toCharArray();
        int N = l1.length;

        int[][] d = new int[2][N];
        for (int i = 0; i < N; i++) {
            d[0][i] = l1[i] == '.' ? 0 : 1;
            d[1][i] = l2[i] == '.' ? 0 : 1;
        }

        for (int[] i : d) {
            CommonUtil.printIntArray(i);
        }

        int[][] route = new int[2][N];
        boolean[][] visited = new boolean[2][N];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.toString());
            int x = node.x;
            int y = node.y;

//            0 0 1 1 0 1 0
//            1 0 1 0 1 0 0
            if (y < N - 1) {
                if (x == 0) {
                    if (visited[x + 1][y] || d[x + 1][y] > d[x][y + 1]) {
                        // 오른쪽 node 가 왼쪽 node 보다 작은 경우, 오른쪽으로 이동 (y + 1)
                        y++;
                    } else {
                        // 아닌 경우, 아래로 이동 (x + 1)
                        x++;
                    }
                } else {
                    if (visited[x - 1][y] || d[x - 1][y] > d[x][y + 1]) {
                        y++;
                    } else {
                        x--;
                    }
                }

                if (!visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Node(x, y));
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("..XX.X.", "X.X.X..")); // 4
//        System.out.println(solution(".XXX...X", "..X.XXXX")); // 6
//        System.out.println(solution("XXXXX", ".X..X")); // 5
//        System.out.println(solution("X...X", "..X..")); // 2

    }

    static class Node {
        public int x;
        public int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
