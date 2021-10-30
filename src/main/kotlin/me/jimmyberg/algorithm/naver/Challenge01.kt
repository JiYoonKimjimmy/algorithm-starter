package me.jimmyberg.algorithm.naver

class Challenge01 {

}

fun main() {
    println(solution(arrayOf("A B C D", "A D", "A B D", "B D"), 2))
    println(solution(arrayOf("JAY", "JAY ELLE JAY MAY", "MAY ELLE MAY", "ELLE MAY", "ELLE ELLE ELLE", "MAY"), 3))
}

fun solution(id_list: Array<String>, k: Int): Int {
    val id_map = mutableMapOf<String, Int>()

    for (i in 0 until id_list.size) {
        val t = mutableMapOf<String, Int>()
        id_list[i].split(" ").forEach {
            if (t[it] == null) {
                t[it] = 1
            }
        }
        t.keys.forEach {
            if (id_map[it] == null) {
                id_map[it] = 1
            } else if (id_map[it]!! < k) {
                id_map[it] = id_map[it]?.plus(1) as Int
            }
        }
    }

    return id_map.values.sum()
}