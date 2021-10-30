package me.jimmyberg.algorithm.naver

class Challenge04 {

}

fun main() {
    solution(arrayOf(
        intArrayOf(1, -7, -2, 1, -1),
        intArrayOf(2, 3, 0, -1, -2),
        intArrayOf(1, -1, 6, -1, -2),
        intArrayOf(-1, 1, -2, 0, 4),
        intArrayOf(-10, 5, -3, -1, 1))
    )
}

fun solution(board: Array<IntArray>): Int {
    val totalSize = board.size
    println(totalSize)

    for (i in 0 until totalSize) {
        for (j in 0 until totalSize) {
            print("$i $j | ")
        }
        println()
    }


    return 0
}