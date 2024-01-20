package me.jimmyberg.algorithm.buketplace

class Test05 {

    /**
     * 2개의 숫자 배열에서 오름차순의 정렬을 유지할 수 있도록 배열 요소를 교환하고자 한다.
     *
     * - a = [150, 170, 180, 180]
     * - b = [150, 160, 170, 190]
     *
     * 위와 같이 a, b 배열에서 3번째 Index 인 180 과 190 을 교환한다면, 아래와 같이 오름차순 정렬이 완성된다.
     *
     * - a = [150, 170, 180, 190]
     * - b = [150, 160, 170, 180]
     *
     * 두 개의 배열의 교환하는 횟수를 반환하는 알고리즘을 구현한다.
     * (단, 이미 두 개의 배열이 동일하다면, 0 을 반환한다.)
     */
    fun solution(a: IntArray, b: IntArray): Int {
        val n = a.size

        if (a.contentEquals(b)) return 0

        // 두 배열을 합친 새로운 배열 생성
        val combined = Array(n) { i -> Pair(a[i], b[i]) }

        // 이미 정렬되어 있는지 확인
//        if (combined.sortedBy { it.first } == combined || combined.sortedBy { it.second } == combined) {
//            return 0
//        }

        // 배열 a를 정렬하기 위한 최소 교환 횟수
        val swapCountA = findMinSwaps(combined.map { it.first }.toIntArray(), combined.map { it.second }.toIntArray())

        // 배열 b를 정렬하기 위한 최소 교환 횟수
        val swapCountB = findMinSwaps(combined.map { it.second }.toIntArray(), combined.map { it.first }.toIntArray())

        // 두 경우 중 최소값 반환
        return minOf(swapCountA, swapCountB)
    }

    fun findMinSwaps(arr1: IntArray, arr2: IntArray): Int {
        val n = arr1.size
        val dp = Array(n) { IntArray(2) { Int.MAX_VALUE } }

        // dp[i][0]: i번째 원소를 교환하지 않았을 때의 최소 교환 횟수
        // dp[i][1]: i번째 원소를 교환했을 때의 최소 교환 횟수

        dp[0][0] = 0
        dp[0][1] = 1

        for (i in 1 until n) {
            // 두 배열 모두 정렬되지 않은 경우
            if (arr1[i] > arr1[i - 1] && arr2[i] > arr2[i - 1]) {
                dp[i][0] = minOf(dp[i][0], dp[i - 1][0])
                dp[i][1] = minOf(dp[i][1], dp[i - 1][1] + 1)
            }

            // 두 배열 모두 정렬된 경우
            if (arr1[i] > arr2[i - 1] && arr2[i] > arr1[i - 1]) {
                dp[i][0] = minOf(dp[i][0], dp[i - 1][1])
                dp[i][1] = minOf(dp[i][1], dp[i - 1][0] + 1)
            }
        }

        return minOf(dp[n - 1][0], dp[n - 1][1])
    }
}

fun main() {
//    val a = intArrayOf(150, 170, 180, 180)
//    val b = intArrayOf(150, 160, 170, 190)

    val a = intArrayOf(150, 170)
    val b = intArrayOf(150, 170)

    val result = Test05().solution(a, b)
    println(result) // 출력: 1
}

