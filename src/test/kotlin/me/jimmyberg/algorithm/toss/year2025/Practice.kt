package me.jimmyberg.algorithm.toss.year2025

import org.junit.jupiter.api.Test
import kotlin.collections.forEach
import kotlin.test.assertEquals

class Practice {

    @Test
    fun practice() {
        val inputs = arrayOf(
            "alice 100 100 100",
            "james 87 79 99",
            "alex 87 65 100",
            "micheal 87 65 100",
            "sophia 33 100 80"
        )

        data class Student(
            val name: String,
            val korean: Int,
            val math: Int,
            val english: Int
        ) {
            val total: Int = korean + math + english
        }

        val result = inputs
            .map { it.split(" ") }
            .map { (n, k, m, e) -> Student(n, k.toInt(), m.toInt(), e.toInt()) }
            .sortedWith(
                compareByDescending<Student> { it.total }
                    .thenByDescending { it.korean }
                    .thenByDescending { it.math }
                    .thenByDescending { it.english }
                    .thenBy { it.name }
            )
            .map { it.name }

        assertEquals("alice", result[0])
        assertEquals("sophia", result[4])
    }

    @Test
    fun practice_backup() {
        val inputs = arrayOf(
            "alice 100 100 100",
            "james 87 79 99",
            "alex 87 65 100",
            "micheal 87 65 100",
            "sophia 33 100 80"
        )
        val array = inputs.map { it.split(" ") }
        val map = mutableMapOf<String, Double>()

        array.forEach {
            val name = it[0]
            val score1 = it[1].toInt() * 1.3
            val score2 = it[2].toInt() * 1.2
            val score3 = it[3].toInt()
            val totalScore = score1 + score2 + score3
            map[name] = totalScore
        }

        val comparator = compareByDescending<Map.Entry<String, Double>> { it.value }
            .thenBy { it.key }

        val result = map.entries
            .sortedWith(comparator)
            .associate { it.key to it.value }
            .map { it.key }

        assertEquals("alice", result[0])
        assertEquals("sophia", result[4])
    }

}