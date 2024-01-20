package me.jimmyberg.algorithm.buketplace

class Test03 {

    /**
     * 음수가 아닌 정수로 구성된 배열 numbers 가 제공된다. reverse(x) 는 x를 역순으로한 결과라고 정의한다.
     * 예를 들면, reverse(456) == 654, reverse(250) = 52 가 된다.
     *
     * numbers 에서 다음을 만족하면 매직페어라고 한다.
     *   - 뽑은 두 숫자의 index 값을 i, j 라고 한다.
     *   - 0 <= i, j < numbers.length
     *   - number[i] + reverse(numbers[j]) == numbers[j] + reverse(numbers[i]
     *
     * 주어진 numbers 에 몇 개의 매직페어가 있는지 반환한다.
     * 그 숫자가 너무 클 경우 `module 10^9 + 7` 한 결과값을 반환한다.
     *
     * 제약사항
     * - 1 <= numbers.length <= 10^5
     * - 0 <= number[i] <= 10^9
     */
    fun solution(numbers: IntArray): Int {
        return findMagicPairs2(numbers) % 1000000007
    }

    private fun findMagicPairs(numbers: IntArray): Int {
        var count = 0

        for (i in numbers.indices) {
            for (j in i + 1 until numbers.size) {
                if (checkMagicPair(numbers, i, j)) {
                    count++
                }
            }
        }

        return count
    }

    private fun findMagicPairs2(numbers: IntArray): Int {
        var count = 0

        for (i in numbers.indices) {
            var right = numbers.lastIndex
            while (i < right) {
                if (checkMagicPair(numbers, i, right)) {
                    count++
                }
                right--
            }
        }

        return count
    }

    private fun checkMagicPair(numbers: IntArray, i: Int, j: Int): Boolean {
        return numbers[i] + reverse(numbers[j]) == numbers[j] + reverse(numbers[i])
    }

    private fun reverse(num: Int): Int {
        var number = num
        var reversedNumber = 0

        while (number != 0) {
            reversedNumber = reversedNumber * 10 + number % 10
            number /= 10
        }

        return reversedNumber
    }

}

fun main() {
    println(Test03().solution(intArrayOf(42, 97, 13, 24, 1, 76)))
}