package me.jimmyberg.algorithm.dp

import kotlin.math.max

class SplitStick

fun main() {
    val p = listOf(0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30)
    println(p)

    println(cutRod(p, 2))
//    println(cutRod(p, 3))
}

fun cutRod(p: List<Int>, n: Int): Int {
    val r = mutableListOf(0)

    for (i in 1..n) {
        var q = -1
        var j = 1
        while (j <= i) {
            println("$q | ${p[j]} | ${r[i - 1]}")
            q = max(q, p[j] + r[i - 1])
            println("$i - $j : $q")
            j++
        }
        r.add(i, q)
    }

    return r[n]
}