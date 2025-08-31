package me.jimmyberg.algorithm.bithumb.year2025

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test {

    /**
     * 주어진 배열 `array` 에서 `k` 크기만큼 수 합산이 제일 큰 수를 반환하시오.
     * - input : array = [2, 3, 5, 6, 7, 1], k = 3 / output : 18
     * - input : array = [10, 1, 2, 10, 10, 8, 2, 5, 1, 1, 10], k = 6 / output : 36
     */
    private fun solution(array: IntArray, k: Int): Int {
        val result = mutableListOf<Int>()
        result.add(array[0])

        for (i in 1 until array.size) {
            val prevSum = if (i >= k) array[i - k] else 0
            val sum = result[i - 1] + array[i] - prevSum
            result.add(sum)
        }

        return result.maxOf { it }
    }

    @Test
    fun test() {
        assertEquals(18, solution(intArrayOf(2, 3, 5, 6, 7, 1), 3))
        assertEquals(44, solution(intArrayOf(10, 1, 2, 10, 10, 8, 2, 5, 9, 1, 10), 6))
    }
}