package me.jimmyberg.algorithm.buketplace.year2024

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReTest01 {

    /**
     * 9개의 버튼이 있는 키패드가 있습니다. 각 버튼은 1부터 9까지 번호가 매겨져 있으며, 각각 소문자 영어 알파벳에 매핑됩니다.
     * 각 버튼이 매칭되는 문자를 선택할 수 있지만 다음 조건을 준수해야 합니다:
     * - 모든 26개의 소문자 영어 알파벳이 매핑되어야 합니다.
     * - 각 문자는 정확히 하나의 버튼에 매핑되어야 합니다.
     * - 각 버튼은 최대 3개의 문자에만 매핑될 수 있습니다.
     * 첫벗째 문자를 입력하려면 해당 버튼을 한번 누르십시오. 두 번째 문자를 입력하려면 해당 버튼을 두 번 누르고, 이와 같은 방식으로 진행합니다.
     * 문자열 s가 주어졌을 때, 키패드를 사용하여 s를 입력하는 데 필요한 최소 키프레스 수를 반환합니다.
     * 각 버튼에 매핑된 문자 및 그 순서를 변경할 수 없습니다.
     * 예를들어, ohouse이라는 문자열이 주어졌을 때, 이 단어를 위한 최적의 키패드 중 하나는 다음과 같은 구성되며, 총 6번의 키프레스로 만들어 낼 수 있습니다.
     * [제약사항]
     * - 1 <= s.length <= 105
     * - 문자열 s는 영어 소문자로만 구성되어 있습니다.
     */
    private fun solution(s: String): Int {
        var answer = 0

//        val sMap = mutableMapOf<Char, Int>()
//        s.forEach {
//            sMap[it] = (sMap[it] ?: 0) + 1
//        }
        val sMap = s.groupingBy { it }.eachCount()

        val sortedMap = sMap.entries.sortedByDescending { it.value }.map { it.key }
        println(sortedMap)

        sortedMap.forEachIndexed { index, entry ->
            val press = when {
                index < 9 -> 1
                index < 18 -> 2
                else -> 3
            }
            answer += press * (sMap[sortedMap[index]] ?: 1)
        }

        return answer
    }

    @Test
    fun test() {
        assertEquals(6, solution("ohouse"))
        assertEquals(15, solution("abcdefghijkl"))
    }

}