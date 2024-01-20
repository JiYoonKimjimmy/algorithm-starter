package me.jimmyberg.algorithm.buketplace

class Test01 {

    /**
     * 주어진 정수 배열 numbers 에서 두 정수의 합이 goal 과 동일한 수를 만들 수 있는 두 정수를 찾는다.
     * 각 문제에서 정답이 될 두 수는 유일하며, 출력값은 해당 쌍이 존재하는 Index 값을 오름차순으로 정렬하여 출력한다.
     *
     * - 입력 : numbers = [4, 3, 5, 1], goal = 4
     * - 출력 : [1, 3]
     * - 제약사항
     *   - 2 <= numbers.length <= 10^4
     *   - -10^9 <= numbers[i] <= 10^9
     *   - -10^9 <= goal <= 10^9
     *   - 각 문제별로 정답은 한 가지만 존재한다.
     */
    fun solution(numbers: IntArray, goal: Int): IntArray {
        val answer = mutableListOf<Int>()

        val numbers_map = numbers.mapIndexed { index, i -> i to index }.sortedBy { it.first }

        var left = 0
        var right = numbers_map.lastIndex

        while (left < right) {
            val left_num = numbers_map[left]
            val right_num = numbers_map[right]
            val sum = left_num.first + right_num.first
            if (sum == goal) {
                answer.add(left_num.second)
                answer.add(right_num.second)
                break
            } else if (sum < goal) {
                left++
            } else {
                right--
            }
        }

        return answer.sorted().toIntArray()
    }

}

fun main() {
//    val numbers = intArrayOf(4, 3, 5, 1)
//    val goal = 4
    val numbers = intArrayOf(3, 2, 4)
    val goal = 6
    Test01().solution(numbers, goal).forEach { println(it) }
    println(Test01().solution(numbers, goal))
}