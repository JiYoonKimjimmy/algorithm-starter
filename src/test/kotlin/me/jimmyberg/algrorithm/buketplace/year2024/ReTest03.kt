package me.jimmyberg.algrorithm.buketplace.year2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReTest03 {

    /**
     * 논문을 게재한 연구자에 대한 인용 영향력 값을 구하는 함수를 작성해주세요.
     * 인용 영향력을 구하기 위해 논문당 다른 논문에 인용된 수 `references` 가 주어집니다.
     * `reference[i]` 는 i번째 논문에 대한 인용 받은 횟루를 의미합니다.
     * 인용 영향력은 다음의 방법으로 계산됩니다.
     * - 과학자는 n개의 논문 중 k개의 논문이 각각 최소한 k개의 인용 회수를 가지고 있어야 합니다.
     * - 다음 n-k 개의 논문은 각각 k개의 인용 회수를 넘지 않아야 합니다.
     * - 이를 만족하는 k 값의 최대값을 인용 영향력으로 판정합니다.
     * [예시]
     * - 입력 : references = [3,0,4,2,8]
     * - 출력 : 3
     * - 설명 : 연구자는 총 5개의 논문을 가지고 있으며, 각각 3, 0, 4, 2, 8 회의 인용을 받았습니다.
     * 이때 연구자는 각각 3회 이상의 인용된 논문이 3편이고, 나머지 2편은 각각 3회 이하 인용되었습니다.
     * 결과 인용 영향력은 3이 됩니다.
     */
    private fun solution(references: IntArray): Int {
        var answer = 0

        // 내림 차순 정렬
        val sorted = references.sortedDescending()

        for (k in sorted.indices) {
            if (sorted[k] >= k + 1) {
                // 현재값이 k 보다 크거나 같은 경우, 최대 k 값으로 판단
                answer = k + 1
            } else {
                break
            }
        }

        return answer
    }

    @Test
    fun test() {
        assertEquals(3, solution(intArrayOf(3, 0, 4, 2, 8)))
        assertEquals(3, solution(intArrayOf(1, 3, 0, 6, 5)))
        assertEquals(4, solution(intArrayOf(10, 8, 5, 5, 4, 4, 2, 1, 0)))
        assertEquals(5, solution(intArrayOf(10, 8, 5, 5, 5, 4, 2, 1, 0)))
        assertEquals(4, solution(intArrayOf(10, 8, 8, 5, 3, 2, 2, 1, 0)))
    }

}