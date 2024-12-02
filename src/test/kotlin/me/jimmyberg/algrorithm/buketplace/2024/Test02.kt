package me.jimmyberg.algrorithm.buketplace.`2024`

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class Test02 {

    /**
     * 어떤 정수 `m`을 의미하는 배열 `numbers`가 주어집니다.
     * 각 `number[k]`는 해당 정수 `m`의 `k번째` 수를 나타내며, `k`는 `0`부터 `numbers.length - 1`까지 `m`의 가장 높은 자릿수부터 순서대로 정렬됩니다.
     * 예를 들어, `numbers = [4,3,1,2]` 는 정수 4312를 의미합니다. 배열의 각 숫자는 0 이상 9 이하이며, 가장 큰 자릿수의 수는 0이 될 수 없습니다.
     * 이때, 다음의 결과를 반환해주세요.
     * - numbers[numbers.length-1] = numbers[numbers.length-1] + 1
     * - 위 계산 결과 number[k] 가 10 이상이 되는 경우, 해당 자리에는 0 을 남기고, 다음 높은 자릿수로 1을 올려 더해 나갑니다.
     * [예시 1]
     * - 입력 : numbers = [2, 2, 0, 3]
     * - 출력 : [2, 2, 0, 4]
     * - 설명 : [2, 2, 0, 3+1] = 가장 오른쪽 자릿수(3)에 1을 더해줍니다.
     * [예시 2]
     * - 입력 : numbers = [1, 9]
     * - 출력 : [2, 0]
     * - 설명 : [1, 9+1] = 가장 오른쪽 자릿수(9)에 1을 더해줍니다. > [1+1, 0] = 앞 계산 결과 해당 자릿수가 (10) 되었기 때문에 1을 왼쪽 자릿수로 옮겨서 더해줍니다.
     */
    private fun solution(numbers: IntArray): IntArray {
        val n = numbers.size
        val result = numbers.copyOf()

        // 가장 오른쪽 자릿수에 1 더하기
        for (i in n - 1 downTo 0) {
            if (result[i] < 9) {
                result[i] += 1
                return result
            }
            result[i] = 0
        }

        // 모든 자리에서 자리 올림이 발생한 경우
        val answer = IntArray(n + 1)
        answer[0] = 1
        return answer
    }

    @Test
    fun test() {
        assertArrayEquals(intArrayOf(2, 2, 0, 4), solution(intArrayOf(2, 2, 0, 3)))
        assertArrayEquals(intArrayOf(2, 0), solution(intArrayOf(1, 9)))
    }

}