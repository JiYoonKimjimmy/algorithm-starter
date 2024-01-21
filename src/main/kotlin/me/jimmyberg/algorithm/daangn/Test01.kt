package me.jimmyberg.algorithm.daangn

class Test01 {

    fun solution(user: List<String>, report: List<String>, k: Int): List<String> {
        val userMap = user.associateBy { it }
        val reportMap = mutableMapOf<String, MutableSet<String>>()

        report
            .map { it.split(" ") }
            .map {
                val user1 = userMap[it[0]]
                val user2 = userMap[it[1]]
                if (user1 != null && user2 != null) {
                    reportMap.putIfAbsent(user2, mutableSetOf())
                    reportMap[user2]?.add(user1)
                }
            }

        println(reportMap)

        return reportMap.filter { it.value.size >= k }.map { it.key }
    }

}

fun main() {
    val user = listOf("A", "B", "C", "D")
    val report = listOf("A B", "B A", "C A", "D A", "C B", "B A", "E A", "B E")
    val k = 3
    val result = Test01().solution(user, report, k)
    println(result)
}