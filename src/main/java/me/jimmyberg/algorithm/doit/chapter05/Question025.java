package me.jimmyberg.algorithm.doit.chapter05;

import me.jimmyberg.algorithm.common.CommonUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문제 025. 친구 관계 파악하기
 * - 0 ~ N - 1 번까지의 순번에서 아래 조건과 일치한 친구 관계가 있는지 파악하기
 * [조건]
 * - A 는 B 와 친구다.
 * - B 는 C 와 친구다.
 * - C 는 D 와 친구다.
 * - D 는 E 와 친구다.
 *
 * [Key Point]
 * - 위와 같은 조건의 관계를 파악하기 위해선 `DFS` 탐색 기법을 활용한다!
 * - 위와 같은 조건를 만족하기 위해서는 깊이가 `5` 이상되는 친구 관계가 형성이 되어있어야 한다.
 * - `DFS` 탐색을 하면서 깊이가 `5` 이상될 경우, 출력 `1` 하고, 아니면 `0` 을 한다.
 *
 * [Sample]
 * 8 8  // 사람 수, 친구 관계의 수
 * 1 7
 * 3 7
 * 4 7
 * 3 4
 * 4 6
 * 3 5
 * 0 4
 * 2 7
 *
 * 1    // 출력
 */
public class Question025 {
    static List<List<Integer>> A;
    static Boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        visited = new Boolean[N + 1];
        A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
            visited[i] = false;
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            A.get(a).add(b);
            A.get(b).add(a);
        }
        for (int i = 0; i < A.size(); i++) {
            if (!visited[i]) {
                dfs(i, 1);
            }
        }

        if (arrive) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void dfs(int k, int depth) {
        if (depth >= 5 || arrive) {
            arrive = true;
            return;
        }

        visited[k] = true;
        CommonUtil.printArray(visited);

        for (Integer i : A.get(k)) {
            if (!visited[i]) {
                dfs(i, depth + 1);
            }
        }

//        visited[k] = false;     // 이게 왜 필요할까?
    }
}
