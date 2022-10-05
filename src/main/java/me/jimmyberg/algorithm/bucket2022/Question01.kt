package me.jimmyberg.algorithm.bucket2022

class Question01 {
    companion object {
        fun solution(arr: IntArray): Int {
            // 홀수, 짝수 배열 분류
            val odd = arr.filter { it % 2 > 0 }
            val even = arr.filter { it % 2 == 0 }

            println("odd : " + cal(odd.size))
            println("even : " + cal(even.size))

            val odd_sum = cal(odd.size)
            val even_sum = if (even.isNotEmpty()) cal(odd.size) * even.size - odd.size else 0

            return odd_sum + even_sum
        }

        private fun cal(n: Int): Int {
            return if (n <= 1) {
                n
            } else {
                if (n % 2 == 0) {
                    (n / 2) + cal(n - 1)
                } else {
                    (n / 2 + 1) + cal(n - 1)
                }
            }
        }
    }
}

fun main() {
    println(Question01.solution(intArrayOf(1, 3, 5)))
//    println(KQuestion01.solution(intArrayOf(1, 2, 3, 4)))
    println(Question01.solution(intArrayOf(1, 2, 3, 4, 5)))
    println(Question01.solution(intArrayOf(1, 2, 3, 4, 5, 6)))
//    println(KQuestion01.solution(intArrayOf(2, 4, 6)))
//    println(KQuestion01.solution(intArrayOf(1, 2, 4)))
//    println(KQuestion01.solution(intArrayOf(1, 3, 5, 7)))
//    println(KQuestion01.solution(intArrayOf(1, 3, 5, 7, 9, 10)))
}