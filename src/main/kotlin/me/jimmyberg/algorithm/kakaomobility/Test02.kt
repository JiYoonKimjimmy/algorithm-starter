package me.jimmyberg.algorithm.kakaomobility

fun main() {
    Test02().solution(3, intArrayOf(1, 3), intArrayOf(2, 2)).also { println(it) }
    Test02().solution(4, intArrayOf(1, 2, 4, 4, 3), intArrayOf(2, 3, 1, 3, 1)).also { println(it) }
    Test02().solution(4, intArrayOf(1, 2, 1, 3), intArrayOf(2, 4, 3, 4)).also { println(it) }
}

class Test02 {

    fun solution(N: Int, A: IntArray, B: IntArray): Boolean {
        val graph = Array(N + 1) { mutableListOf<Int>() }
        val check = (A + B).flatMap { listOf(it.toString()) }.distinct().sorted().joinToString("")

        A.indices.forEach { i ->
            graph[A[i]].add(B[i])
            graph[B[i]].add(A[i])
        }

        val visited = BooleanArray(N + 1)
        var path = ""

        fun dfs(node: Int, target: Int): Boolean {
            path += node.toString()
            if (node == target) return true

            visited[node] = true

            for (n in graph[node]) {
                if (!visited[n] && dfs(n, target)) {
                    return true
                }
            }
            return false
        }

        dfs(1, N)

        return check.contains(path)
    }
}