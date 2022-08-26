package me.jimmyberg.algorithm.programmers.skillchecks.level3

class Question001 {
    fun solution(s: String): Int {
        var answer = 0
        var start = 0
        var end = s.length

        for (i in s.indices) {
            val partition = s.substring(start, end)
            val reverse = partition.reversed()
            if (partition == reverse) {
                answer = partition.length
                break
            } else {
                if (start < end) {
                    end--
                }
                if (start == end) {
                    start++
                    end = s.length
                }
            }
        }

        return answer
    }
}

fun main() {
    val solution = Question001()
    println(solution.solution("abcdcba"))
    println(solution.solution("abacde"))
}