package me.jimmyberg.algorithm.buketplace.year2024

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Test05 {

    /**
     * 당신은 어떤 이벤트에 참가하여, 동전 줍기 게임을 하게 되었습니다.
     * 이 게임에서는 정사각형 모양의 발판이 세로 M개, 가로 N개의 격자 모양으로 정렬되어 있고, 각 발판에는 몇 개씩의 동전이 뿌려져 있습니다.
     * 당신은 발판을 돌아다니며 동전을 주울 수 있는데, 다음 규칙을 지켜야 합니다.
     * - 처음으로 밟을 수 있는 발판의 위치는 가장 윗줄 중에 있고, 주최즉에서 정해준다.
     * - 한 번에 1개의 발판을 밟을 수 있다.
     * - 밟고 있는 발판에 있는 동전을 모두 주울 수 있다.
     * - 한 발판에서 다른 발판으로 넘어갈 때, 반드시 밑으로 내려가야 하며 대각선으로는 1칸 범위까지 건너갈 수 있다.
     *      - 현재 밟고 있는 발판의 좌표가 (y, x)라면, 다음으로 밟는 발판의 좌표는 (y+1, x), (y+1, x-1), (y+1, x+1) 중 하나만 가능하다.
     * - 더이상 밟을 수 있는 발판이 없을 때까지(즉, 가장 밑으로 왔을 때까지) 진행한다.
     * 당신은 이 게임에서 더블 찬스를 써서, 발판을 돌아다니며 동전을 주울 수 있는 기회를 2번 얻었습니다.
     * 첫 번째 기회에서 처음 밟는 발판은 가장 왼쪽 위 구석(좌표 (0,0))이고, 두 번째 기회에서 처음 밟는 발판은 가장 오른쪽 위 구석(좌표 (0, N-1)) 입니다.
     * 2번의 기회 동안 발판에 있는 동전이 다시 채워지지는 않습니다. 줍는 동전의 개수를 최대화해 보세요.
     * [예시]
     * - 입력 : coins = [[4, 0, 1], [3, 6, 2], [5, 7, 7], [4, 2, 2]]
     * - 출력 : 34
     * - 설명 : 1번째 기회에 4+3+7+4 = 18개, 2번째 기회에 1+6+7+2=16개의 동전을 얻어서 총 34개의 동적을 얻을 수 있습니다.
     */
    private fun solution(coins: Array<IntArray>): Int {
        val rows = coins.size
        val cols = coins[0].size

        // DP table to store the maximum coins collected
        val dp = Array(rows) { Array(cols) { IntArray(cols) } }

        // Initialize the first row
        for (j in 0 until cols) {
            for (k in 0 until cols) {
                dp[0][j][k] = if (j == k) coins[0][j] else coins[0][j] + coins[0][k]
            }
        }

        // Fill the DP table
        for (i in 1 until rows) {
            for (j in 0 until cols) {
                for (k in 0 until cols) {
                    var maxCoins = 0
                    for (dj in -1..1) {
                        for (dk in -1..1) {
                            val prevJ = j + dj
                            val prevK = k + dk
                            if (prevJ in 0 until cols && prevK in 0 until cols) {
                                maxCoins = maxOf(maxCoins, dp[i - 1][prevJ][prevK])
                            }
                        }
                    }
                    dp[i][j][k] = maxCoins + if (j == k) coins[i][j] else coins[i][j] + coins[i][k]
                }
            }
        }

        // Find the maximum coins collected in the last row
        var maxCoins = 0
        for (j in 0 until cols) {
            for (k in 0 until cols) {
                maxCoins = maxOf(maxCoins, dp[rows - 1][j][k])
            }
        }

        return maxCoins
    }

    @Test
    fun test() {
        val coins = arrayOf(
            intArrayOf(4, 0, 1),
            intArrayOf(3, 6, 2),
            intArrayOf(5, 7, 7),
            intArrayOf(4, 2, 2)
        )
        assertEquals(34, solution(coins))
    }

}