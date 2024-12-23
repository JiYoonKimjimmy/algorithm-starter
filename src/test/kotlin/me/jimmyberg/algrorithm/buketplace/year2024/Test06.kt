package me.jimmyberg.algrorithm.buketplace.year2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.math.abs

class Test06 {

    /**
     * [4, 5], [-2, -3], [-1, 0], [-1, 2]
     * 위과 같은 동일한 크기의 숫자 배열을 4개씩 주어진다고 할 때,
     * 4개의 배열에서 하나씩 숫자를 꺼내 합산한 값이 `0` 인 경우의 수를 구하시오.
     * [제약 조건]
     * - 배열의 크기는 최대 300 까지 가능하다.
     * - 배열안의 숫자는 Int 형 크기만큼 지정 가능하다.
     */
    private fun solution(
        nums1: IntArray,
        nums2: IntArray,
        nums3: IntArray,
        nums4: IntArray,
    ): Int {
        val map = mutableMapOf<Int, Int>()

        for (a in nums1) {
            for (b in nums2) {
                val sum = a + b
                map[sum] = map.getOrDefault(sum, 0) + 1
            }
        }

        var answer = 0

        for (c in nums3) {
            for (d in nums4) {
                val sum = c + d
                answer += map.getOrDefault(-sum, 0)
            }
        }

        return answer
    }

    @Test
    fun test() {
        assertEquals(3, solution(intArrayOf(4, 5), intArrayOf(-2, -3), intArrayOf(-1, 0), intArrayOf(-1, 2)))
    }

}