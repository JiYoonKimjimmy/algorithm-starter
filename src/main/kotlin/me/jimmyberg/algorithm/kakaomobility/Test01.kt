package me.jimmyberg.algorithm.kakaomobility

fun main() {
    Test01().solution1(54321)
    Test01().solution1(12345)
    Test01().solution1(123450)
}

class Test01 {

    fun solution1(N_arg: Int) {
        var N: Int = N_arg
        var enable_print: Int

        enable_print = N % 10

        while (N > 0 && enable_print != 0) {
            if (N % 10 != 0) {
                enable_print = 1
            }
            if (enable_print >= 1) {
                print(N % 10)
            }
            N = N / 10
        }
        println()
    }

}