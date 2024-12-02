package me.jimmyberg.algrorithm.buketplace.`2024`

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class Test04 {

    /**
     * m행 n열의 격가 board 에 알파벳 하나씩 입력되어 있습니다.
     * 주어진 단어 `word` 를 격자판에서 만들 수 있다면 true, 없다면 false를 반환하는 프로그램을 만들어주세요.
     * 단어를 만들때, 셀의 글자들이 수직 혹은 수평으로 인접해 있어햐 하며, 같은 위치의 단어는 한 번만 사용이 가능합니다.
     * 또 단어의 순서는 입력된 단어와 동일해야 하며, 대소문자가 구분됩니다.
     * [예시]
     * - 입력 : board = [["O", "A", "C", "D", "E", "O"], ["H", "O", "T", "C", "A", "P"], ["P", "U", "S", "E", "T", "Z"]]
     * - 출력 : true
     * - 설명 : 아래와 같이 격자가 생셩되며, (0,0)부터 "/" 표기된 문자를 읽으면 "OHOUSE" 가 생성됩니다.
     * [/O A C D E O]
     * [/H /O T C A P]
     * [P /U /S /E T Z]
     */
    private fun solution(board: Array<Array<String>>, word: String): Boolean {
        val rows = board.size
        val cols = board[0].size
        val visited = Array(rows) { BooleanArray(cols) }

        fun dfs(x: Int, y: Int, index: Int): Boolean {
            if (index == word.length) return true
            if (x < 0 || x >= rows || y < 0 || y >= cols ||
                visited[x][y] || board[x][y] != word[index].toString()) return false

            visited[x][y] = true

            val result = dfs(x + 1, y, index + 1) ||
                    dfs(x - 1, y, index + 1) ||
                    dfs(x, y + 1, index + 1) ||
                    dfs(x, y - 1, index + 1)

            visited[x][y] = false

            return result
        }

        for (i in 0 until rows) {
            for (j in 0 until cols) {
                if (dfs(i, j, 0)) return true
            }
        }

        return false
    }

    @Test
    fun test() {
        val board = arrayOf(
            arrayOf("O", "A", "C", "D", "E", "O"),
            arrayOf("H", "O", "T", "C", "A", "P"),
            arrayOf("P", "U", "S", "E", "T", "Z")
        )
        Assertions.assertEquals(true, solution(board, "OHOUSE"))
    }

}